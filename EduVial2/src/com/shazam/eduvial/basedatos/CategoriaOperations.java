package com.shazam.eduvial.basedatos;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

	public class CategoriaOperations {

		// Database fields
		private DataBaseWrapper dbHelper;
		private String[] CATEGORIA_TABLE_COLUMNS = { DataBaseWrapper.CODCATEGORIA, DataBaseWrapper.NOMBRE};
		private SQLiteDatabase database;

		public CategoriaOperations(Context context) {
			dbHelper = new DataBaseWrapper(context);
		}

		public void open() throws SQLException {
			database = dbHelper.getWritableDatabase();
		}

		public void close() {
			dbHelper.close();
		}

		public Categoria addCategoria(String name) {

			ContentValues values = new ContentValues();

			values.put(DataBaseWrapper.NOMBRE, name);

			long codCategoria = database.insert(DataBaseWrapper.CATEGORIA, null, values);

			// now that the student is created return it ...
			Cursor cursor = database.query(DataBaseWrapper.CATEGORIA,
					CATEGORIA_TABLE_COLUMNS, DataBaseWrapper.CODCATEGORIA + " = "
							+ codCategoria, null, null, null, null);

			cursor.moveToFirst();

			Categoria newComment = parseCategoria(cursor);
			cursor.close();
			return newComment;
		}

		public void deleteCategoria(Categoria comment) {
			long codCategoria = comment.getCodCategoria();
			System.out.println("Comment deleted with id: " + codCategoria);
			database.delete(DataBaseWrapper.CATEGORIA, DataBaseWrapper.CODCATEGORIA
					+ " = " + codCategoria, null);
		}

		public List<Categoria> getAllCategorias() {
			List<Categoria> categorias = new ArrayList<Categoria>();

			Cursor cursor = database.query("Categoria",
					CATEGORIA_TABLE_COLUMNS, null, null, null, null, null);

			cursor.moveToFirst();
			while (!cursor.isAfterLast()) {
				Categoria categoria = parseCategoria(cursor);
				categorias.add(categoria);
				cursor.moveToNext();
			}

			cursor.close();
			return categorias;
		}

		private Categoria parseCategoria(Cursor cursor) {
			Categoria cat = new Categoria(cursor.getInt(0), cursor.getString(1));
			
			return cat;
		}
	}
