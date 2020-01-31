package com.example.newfirstapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment
{
    TextView showCountTextView;

    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState)
    {
        View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);
        showCountTextView = fragmentFirstLayout.findViewById(R.id.textview_first);

        return fragmentFirstLayout;
    }

    //what does inflater do?
    @Override
    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View v, Bundle savedInstanceState)
    {
        super.onViewCreated(v, savedInstanceState);

        v.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int currentCount = Integer.parseInt(showCountTextView.getText().toString());

                FirstFragmentDirections.ActionFirstFragmentToSecondFragment action =
                        FirstFragmentDirections.
                                actionFirstFragmentToSecondFragment(currentCount);
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(action);
            }
        });
    }



    view.findViewById(R.id.random_button).setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v)
        {
            FirstFragmentDirections.ActionFirstFragmentToSecondFragment action =
                    FirstFragmentDirections.
                            actionFirstFragmentToSecondFragment("From FirstFragment");
            NavHostFragment.findNavController(FirstFragment.this)
                    .navigate(action);
        }
    });

    view.findViewById(R.id.count_button).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            countMe(v);
        }
    });

    view.findViewById(R.id.toast_button).setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
    {
            Toast myToast = Toast.makeText(getActivity(), "Hello toast!", Toast.LENGTH_SHORT);
            myToast.show();
        }
    });

    void countMe(View v)
    {
        String count = showCountTextView.getText().toString();
        Integer count = Integer.parseInt(count);
        count++;
        showCountTextView.setText(count.toString());
    }
}
