package com.shazam.eduvial.basedatos;

	public class Infraccion {
		
		private int codInfraccion;
		private float monto;
		private String descripcion;
		private int codCategoria;
		
		public Infraccion(int CI, float M, String D, int CC){
			this.codInfraccion = CI;
			this.monto = M;
			this.descripcion = D;
			this.codCategoria = CC;
		}
		
		public Infraccion(){
			
		}
		
		public int getCodInfraccion(){
			return codInfraccion;
		}
		
		public float getMonto(){
			return monto;
		}
		
		public String getDescripcion(){
			return descripcion;
		}
		
		public int getCodCategoria(){
			return codCategoria;
		}
		
		public void setCodInfraccion(int CI){
			this.codInfraccion = CI;
		}
		
		public void setMonto(float M){
			this.monto = M;
		}
		
		public void setDescripcion(String D){
			this.descripcion = D;
		}
		
		public void setCodCategoria(int CC){
			this.codCategoria = CC;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.descripcion + " -- valor C$"+ String.valueOf(this.monto+"0");
		}
		
		
}
