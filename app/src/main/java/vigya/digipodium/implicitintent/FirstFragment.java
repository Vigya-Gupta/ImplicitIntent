package vigya.digipodium.implicitintent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CardView cardCall=view.findViewById(R.id.cardCall);
        cardCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        CardView cardMsg=view.findViewById(R.id.cardMsg);

        cardMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_thirdFragment);
            }
        });

        CardView cardWeb=view.findViewById(R.id.cardWeb);

        cardWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_fourthFragment);
            }
        });

        CardView cardClock = view.findViewById(R.id.cardClock);

        cardClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_fifthFragment);
            }
        });

        CardView cardCalendar= view.findViewById(R.id.cardCalendar);

        cardCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_fifthFragment);
            }
        });
    }
}