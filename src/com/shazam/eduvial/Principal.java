package com.shazam.eduvial;

import java.util.List;

import com.shazam.eduvial.basedatos.Categoria;
import com.shazam.eduvial.basedatos.CategoriaOperations;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.support.v7.internal.widget.AdapterViewCompat.OnItemSelectedListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;


public class Principal extends ActionBarActivity implements OnItemSelectedListener {

	Spinner spinner;
	Button btnBuscar;
	EditText inputLabel; 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        
        spinner = (Spinner) findViewById(R.id.spinner1);
        inputLabel = (EditText) findViewById(R.id.edtextBuscar);
        btnBuscar = (Button) findViewById(R.id.buttonBuscar);
        
        //spinner.setOnItemSelectedListener(this);
        
        try{
        CategoriaOperations CatOp = new CategoriaOperations(this);
        CatOp.open();

		List<Categoria> values = CatOp.getAllCategorias();
		//values.add(10,new Categoria(10,"Todos"));
		ArrayAdapter<Categoria> dataAdapter = new ArrayAdapter<Categoria>(this,android.R.layout.simple_spinner_item, values); 
		
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
		spinner.setAdapter(dataAdapter);
		 
		CatOp.close();
		}catch(Exception ex){
			Toast.makeText(this, ex.toString(), Toast.LENGTH_LONG).show();
    	}
                        
        btnBuscar.setOnClickListener(new View.OnClickListener() {  
        	   
            @Override  
            public void onClick(View arg0) {  
                String label = inputLabel.getText().toString();  
               /* if (label.trim().length() > 0) {  
                	Toast.makeText(getApplicationContext(), "Está buscando: "+ label,  
                            Toast.LENGTH_SHORT).show();  */
                	try{       	
                		Intent i = new Intent(getApplicationContext(), Resultado.class);
                		i.putExtra("var_categoria", spinner.getSelectedItem().toString());
                		i.putExtra("var_idcategoria", String.valueOf(spinner.getSelectedItemPosition()+ 1));
                		i.putExtra("var_criterio", label);
                		startActivity(i);
                      	}catch(Exception ex){
					Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_LONG).show();
                	}
                	
                /*} else {  
                    Toast.makeText(getApplicationContext(), "Por favor escriba el término a buscar",  
                            Toast.LENGTH_SHORT).show();  
                }  */
              }  
        });
        
        	inputLabel.setOnEditorActionListener(new OnEditorActionListener() {


			@Override
			public boolean onEditorAction(TextView arg0, int arg1, KeyEvent arg2) {
				btnBuscar.performClick();
				return true;
			}
        });
        
        spinner.setSelection(9);
        
    }  

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public void onItemSelected(AdapterViewCompat<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onNothingSelected(AdapterViewCompat<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
