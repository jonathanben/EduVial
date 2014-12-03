package com.shazam.eduvial.basedatos;

public class Categoria {
	private int codCategoria;
	private String nombre;
	
	public Categoria(int CodCat, String Nom){
		this.codCategoria = CodCat;
		this.nombre = Nom;
	}
	
	public Categoria(){
		
	}
	
	public int getCodCategoria(){
		return codCategoria;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setCodCategoria(int CC){
		this.codCategoria = CC;
	}
	
	public void setNombre(String N){
		this.nombre = N;
	}
	
	@Override
    public String toString() {
        return this.nombre;
    }
	
	
	
}
