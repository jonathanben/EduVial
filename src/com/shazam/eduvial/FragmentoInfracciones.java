package com.shazam.eduvial;

import java.util.List;

import com.shazam.eduvial.basedatos.InfraccionOperations;
import com.shazam.eduvial.basedatos.Infraccion;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class FragmentoInfracciones extends ListFragment{
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
    	 return inflater.inflate(R.layout.fragment_infraccion, container, false);
    }
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
 
    	// TODO Auto-generated method stub
    	try{
    	super.onCreate(savedInstanceState);
            		
    		InfraccionOperations InfOp = new InfraccionOperations(getActivity());
    		InfOp.open();
    		
    		List<Infraccion> values;
    		if(getActivity().getIntent().getStringExtra("var_idcategoria").equals("10")){
    			 values = InfOp.getInfraccionCriterio(getActivity().getIntent().getStringExtra("var_criterio"));
    		}
    		else
    		{
    			values = InfOp.getInfraccionporCategoriaCriterio(getActivity().getIntent().getStringExtra("var_idcategoria"),
    			getActivity().getIntent().getStringExtra("var_criterio"));
    		}
    		
    		// Use the SimpleCursorAdapter to show the
    		// elements in a ListView
    				setListAdapter(new ArrayAdapter<Infraccion>(
    		        getActivity(),
    		        android.R.layout.simple_list_item_1,
    		        values));
    				
    		InfOp.close();
    		}catch(Exception ex){
    					Toast.makeText(getActivity(), ex.toString(), Toast.LENGTH_LONG).show();
       	}
    }
}
 