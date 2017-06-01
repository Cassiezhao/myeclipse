package com.example.login1.factory;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

import com.example.login1.fragment.MessageFragment;
import com.example.login1.fragment.PassFragment;
import com.example.login1.fragment.PhoneFragment;

/*
 * Created by Administrator on 2016/10/22.
 */
public class FragmentFactory {

    /**
     * android 提供轻量级的map集合  k-v  k只能是int类型  v可以是任意类型
     */
    private static SparseArray<Fragment> sparseArray = new SparseArray<>();

    /**
     * 根据下标位置获取fragment
     *
     * @param position
     * @return
     */
    public static Fragment getFragment(int position) {
        // 先从集合中取出fragment  如果为空就创建
        Fragment fragment = sparseArray.get(position);
        if (fragment == null) {
            switch (position) {
                case 0:
                    fragment = new MessageFragment();
                    break;
                case 1:
                    fragment = new PassFragment();
                    break;
                case 2:
                    fragment=new PhoneFragment();
                    break;
            }
            sparseArray.put(position, fragment);
        }
        return fragment;
    }
}
