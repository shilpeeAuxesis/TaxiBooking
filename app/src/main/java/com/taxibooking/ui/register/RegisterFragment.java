package com.taxibooking.ui.register;
import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.taxibooking.R;
import com.taxibooking.ui.register.resister_model.RegisterModel;
import java.util.ArrayList;
import java.util.List;
import static com.taxibooking.ui.constant.Utils.isInternetConnected;

public class RegisterFragment extends Fragment {
    private static final String TAG = "RegisterFragment";
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    EditText edtName, edtEmail, edtPassword, edtRepeatPass;
    Button btnLogin;
    String error_msg = "";
    DatabaseReference mDatabaseReference = null;
    SomeDisplay mDisplay = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mDisplay = (SomeDisplay) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_register, container, false);
        mDatabaseReference = mDatabase.getReference().child("data");
        getInitUI(root);
        return root;
    }

    void getInitUI(View root) {
        edtName = root.findViewById(R.id.edtName);
        edtEmail = root.findViewById(R.id.edtEmail);
        edtPassword = root.findViewById(R.id.edtPassword);
        edtRepeatPass = root.findViewById(R.id.edtRepeatPass);
        btnLogin = root.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInternetConnected(getActivity())) {
                    if (Validation()) {
                        if (edtPassword.getText().toString().trim().equals(edtRepeatPass.getText().toString().trim())) {
                            if (mDatabaseReference!=null) {
                                mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        List<RegisterModel> adsList = new ArrayList<RegisterModel>();
                                        for (DataSnapshot adSnapshot: dataSnapshot.getChildren()) {

                                            if (adSnapshot.child("name").exists()) {
                                                if (edtEmail.getText().toString().trim().equals(adSnapshot.child("name").getValue())){

                                                }else {

                                                }
                                                Log.d(TAG, "onDataChange: "+adSnapshot.child("name").getValue());



                                                //do ur stuff
                                            } else {
                                                //do something if not exists
                                            }
                                            adsList.add(adSnapshot.getValue(RegisterModel.class));
                                        }
                                        Log.d(TAG, "no of records of the search is "+adsList.size());
                                        Log.d(TAG, "no of records of the search is "+adsList.get(0).getEmail());
                                    }
                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {
                                       // Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
                                        Toast.makeText(getActivity(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                                getRegister();
                            }
                        } else {
                            Toast.makeText(getActivity(), "Password and repeat password must be same", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getActivity(), error_msg, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), getResources().getString(R.string.oops_connect_your_internet), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void getRegister() {
        String name = edtName.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String pass = edtPassword.getText().toString().trim();
        String rePass = edtRepeatPass.getText().toString().trim();
        RegisterModel registerModel = new RegisterModel(name, email, pass, rePass);
        mDatabaseReference.push().setValue(registerModel);
        edtName.setText("");
        edtEmail.setText("");
        edtPassword.setText("");
        edtRepeatPass.setText("");
        Toast.makeText(getActivity(), getResources().getString(R.string.register_succ), Toast.LENGTH_SHORT).show();
        mDisplay.onDisplay();
    }

    private boolean Validation() {
        error_msg = "";
        if (TextUtils.isEmpty(edtName.getText().toString().trim())) {
            error_msg = getString(R.string.hint_name);
            return false;
        } else if (TextUtils.isEmpty(edtEmail.getText().toString().trim())) {
            error_msg = getString(R.string.hint_email);
            return false;
        } else if (TextUtils.isEmpty(edtPassword.getText().toString().trim())) {
            error_msg = getString(R.string.hint_password);
            return false;
        } else if (TextUtils.isEmpty(edtRepeatPass.getText().toString().trim())) {
            error_msg = getString(R.string.hint_repassword);
            return false;
        } else {
            return true;
        }
    }
}
