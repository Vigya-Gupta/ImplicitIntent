package vigya.digipodium.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class ThirdFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText phoneNum = view.findViewById(R.id.phoneNum);
        TextInputLayout textInput=view.findViewById(R.id.textInput);
        final TextInputEditText msg=view.findViewById(R.id.msg);
        Button btnSend = view.findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p=phoneNum.getText().toString();
                String message = msg.getText().toString();
                Uri attachment = Uri.parse(p);
                composeMmsMessage(message,attachment);
            }
        });
    }

    public void composeMmsMessage(String message, Uri attachment) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("smsto:"+attachment));  // This ensures only SMS apps respond
        intent.putExtra("sms_body", message);
        //intent.putExtra(Intent.EXTRA_STREAM, attachment);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}