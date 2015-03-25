package com.slidenerd.exmples.two.navigationdrawer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by bharat.sumanth on 3/24/2015.
 */
public class FragmentA extends Fragment {
    public TextView textView;
    public View rootLayout;
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_a,container,false);

    }
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        textView = (TextView) getActivity().findViewById(R.id.textView);
        rootLayout = getActivity().findViewById(R.id.rootLayout);

    }

}
