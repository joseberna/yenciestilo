package com.devandroid.yenciestilo.fragmentos;
import com.example.yenciestilo.R;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Contactame extends Fragment {
	public static Fragment newInstance(Context context) {
		Contactame f = new Contactame();
		return f;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		ViewGroup root = (ViewGroup) inflater.inflate(R.layout.contactame,
				null);
		return root;
	}
}