package com.shazam.eduvial.basedatos;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class InfraccionOperations {

	// Database fields
	private DataBaseWrapper dbHelper;
	private String[] INFRACCION_TABLE_COLUMNS = { DataBaseWrapper.CODINFRACCION, DataBaseWrapper.MONTO, DataBaseWrapper.DESCRIPCION, DataBaseWrapper.CODCATEGORIA};
	private SQLiteDatabase database;

	public InfraccionOperations(Context context) {
		dbHelper = new DataBaseWrapper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public Infraccion addInfraccion(float monto, String Descripcion, int codCategoria) {

		ContentValues values = new ContentValues();

		values.put(DataBaseWrapper.MONTO, monto);
		values.put(DataBaseWrapper.DESCRIPCION, Descripcion);
		values.put(DataBaseWrapper.CODCATEGORIA, codCategoria);

		long codInfraccion = database.insert(DataBaseWrapper.INFRACCION, null, values);

		// now that the student is created return it ...
		Cursor cursor = database.query(DataBaseWrapper.INFRACCION,
				INFRACCION_TABLE_COLUMNS, DataBaseWrapper.CODINFRACCION + " = "
						+ codInfraccion, null, null, null, null);

		cursor.moveToFirst();

		Infraccion newComment = parseInfraccion(cursor);
		cursor.close();
		return newComment;
	}

	public void deleteInfraccion(Infraccion comment) {
		long codInfraccion = comment.getCodInfraccion();
		System.out.println("Comment deleted with id: " + codInfraccion);
		database.delete(DataBaseWrapper.INFRACCION, DataBaseWrapper.CODINFRACCION
				+ " = " + codInfraccion, null);
	}

	public List<Infraccion> getAllInfracciones() {
		List<Infraccion> infracciones = new ArrayList<Infraccion>();

		Cursor cursor = database.query("Infraccion",
				INFRACCION_TABLE_COLUMNS, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Infraccion infraccion = parseInfraccion(cursor);
			infracciones.add(infraccion);
			cursor.moveToNext();
		}
		cursor.close();
		return infracciones;
	}
	
	public List<Infraccion> getInfraccionCriterio(String Criterio) {
		List<Infraccion> infracciones = new ArrayList<Infraccion>();

		Cursor cursor = database.query("Infraccion",
				INFRACCION_TABLE_COLUMNS, "Descripcion LIKE '%" + Criterio+"%'", null, null, null, null);
		
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Infraccion infraccion = parseInfraccion(cursor);
			infracciones.add(infraccion);
			cursor.moveToNext();
		}

		cursor.close();
		return infracciones;
	}

	
	public List<Infraccion> getInfraccionporCategoriaCriterio(String idcategoria, String Criterio) {
		List<Infraccion> infracciones = new ArrayList<Infraccion>();

		Cursor cursor = database.query("Infraccion",
				INFRACCION_TABLE_COLUMNS, DataBaseWrapper.CODCATEGORIA + " = "+idcategoria +" AND Descripcion LIKE '%" + Criterio+"%'", null, null, null, null);
		
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Infraccion infraccion = parseInfraccion(cursor);
			infracciones.add(infraccion);
			cursor.moveToNext();
		}

		cursor.close();
		return infracciones;
	}

	private Infraccion parseInfraccion(Cursor cursor) {
		Infraccion inf = new Infraccion(cursor.getInt(0), cursor.getFloat(1), cursor.getString(2), cursor.getInt(3));
		
		return inf;
	}
}
