package com.devandroid.yenciestilo;

import com.example.yenciestilo.R;

import android.support.v4.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends FragmentActivity {
	ListView drawer;
	DrawerLayout drawerLayout;
	ActionBarDrawerToggle toggle;
	String[] opciones;
	final String[] fragments = {
			"com.devandroid.yenciestilo.fragmentos.Conoceme",
			"com.devandroid.yenciestilo.fragmentos.ProyeccionImagen",
			"com.devandroid.yenciestilo.fragmentos.SeminariosTalleres",
			"com.devandroid.yenciestilo.fragmentos.ProtocoloEtiqueta",
			"com.devandroid.yenciestilo.fragmentos.Tips",
			"com.devandroid.yenciestilo.fragmentos.Contactame" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		drawer = (ListView) findViewById(R.id.drawer);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		opciones = getResources().getStringArray(R.array.menu_array);
		drawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
		drawer.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1,
				opciones));
		// drawer.setOnItemClickListener(new DrawerItemClickListener());

		drawer.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					final int pos, long id) {
				drawerLayout
						.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
							@Override
							public void onDrawerClosed(View drawerView) {
								super.onDrawerClosed(drawerView);
								FragmentTransaction tx = getSupportFragmentManager()
										.beginTransaction();
								tx.replace(R.id.main, Fragment.instantiate(
										MainActivity.this, fragments[pos]));
								getActionBar().setTitle(
										(CharSequence) opciones[pos]);
								tx.commit();
							}
						});
				drawerLayout.closeDrawer(drawer);
			}
		});
		FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
		tx.replace(R.id.main,
				Fragment.instantiate(MainActivity.this, fragments[0]));
		tx.commit();
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		toggle = new ActionBarDrawerToggle(this, drawerLayout,
				R.drawable.ic_drawer, R.string.app_name, 0) {

			/*
			 * 
			 * AQUI!
			 */
		};
		drawerLayout.setDrawerListener(toggle);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		if (toggle.onOptionsItemSelected(item)) {
			return true;
		} else {
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		toggle.syncState();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
