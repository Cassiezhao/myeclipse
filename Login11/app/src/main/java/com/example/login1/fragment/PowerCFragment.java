package com.example.login1.fragment;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.login1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PowerCFragment extends Fragment implements View.OnClickListener {


    public PowerCFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_power_c, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        view.findViewById(R.id.gl1).setOnClickListener(this);
        view.findViewById(R.id.gl2).setOnClickListener(this);
        view.findViewById(R.id.gl3).setOnClickListener(this);
        view.findViewById(R.id.gl4).setOnClickListener(this);
        view.findViewById(R.id.gl5).setOnClickListener(this);
        view.findViewById(R.id.fanhui).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gl1:
                //评价信息
                new AlertDialog.Builder(getActivity())
                .setMessage("您已将发射距离设置为10m")
                        .setPositiveButton("确定",null)
                .show();
                //ToastUtils.toast("您已将发射距离设置为10m");
                break;
            case R.id.gl2:
                new AlertDialog.Builder(getActivity())
                        .setMessage("您已将发射距离设置为20m")
                        .setPositiveButton("确定",null)
                        .show();
                break;
            case R.id.gl3:
                new AlertDialog.Builder(getActivity())
                        .setMessage("您已将发射距离设置为30m")
                        .setPositiveButton("确定",null)
                        .show();
                break;
            case R.id.gl4:
                new AlertDialog.Builder(getActivity())
                        .setMessage("您已将发射距离设置为40m")
                        .setPositiveButton("确定",null)
                        .show();
               break;
            case R.id.gl5:
                new AlertDialog.Builder(getActivity())
                        .setMessage("您已将发射距离设置为50m")
                        .setPositiveButton("确定",null)
                        .show();
                break;
            case R.id.fanhui:
                getFragmentManager().popBackStack();
                break;
            default:
                break;

        }
    }

}
