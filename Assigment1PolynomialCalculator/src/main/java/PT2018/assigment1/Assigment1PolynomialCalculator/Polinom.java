package PT2018.assigment1.Assigment1PolynomialCalculator;


import java.util.ArrayList;

import java.util.Collections;

public class Polinom implements Cloneable {

	
	private ArrayList<Monom> monom = new ArrayList<Monom>();
	
	public Polinom(String[] mon) {

		for(int i=0; i<mon.length; i++) {
			if(!mon[i].isEmpty()) {
				monom.add(new Monom(mon[i]));
			}	
		}
		this.sortareSiEliminareDuplicate();
	}

	public Polinom() {};
	
	public Polinom(ArrayList<Monom> monom) {
		this.monom=monom;
	}
	public void setMonom(ArrayList<Monom> monom) {
		this.monom = monom;
	}
	public Polinom add(Polinom p) {
		Polinom pNew = new Polinom();//polinomul in care se memoreaza suma
		
		for(Monom m:monom) {
			int exponent1=m.getExponent();
			double coeficient1=m.getCoeficient();
			int indexExponent=p.getExponentIndex(exponent1);
			if(indexExponent==-1) {
				pNew.monom.add(new Monom(exponent1,coeficient1));//daca exponentul exista doar in primul polinom atunci de adauga
			}
			else {
				int exponent2=p.monom.get(indexExponent).getExponent();
				double coeficient2=p.monom.get(indexExponent).getCoeficient();
				pNew.monom.add(new Monom(exponent2,coeficient1+coeficient2));
				p.monom.remove(indexExponent);
			}
		}
		for(Monom m:p.monom) {//se adauga ce a ramas in al doilea polinom
			int exponent3=m.getExponent();
			double coeficient3=m.getCoeficient();
			pNew.monom.add(new Monom(exponent3,coeficient3));
		}
		pNew.sortareSiEliminareDuplicate();
		return pNew;
	}
	public Polinom subtract(Polinom p) {
		Polinom pNew = new Polinom();//polinomul in care se memoreaza diferenta
		for(Monom m:monom) {
			int exponent1=m.getExponent();
			double coeficient1=m.getCoeficient();
			int indexExponent=p.getExponentIndex(exponent1);
			if(indexExponent==-1) {
				pNew.monom.add(new Monom(exponent1,coeficient1));//exponentul exista doar in primul polinom
			}
			else {
				int exponent2=p.monom.get(indexExponent).getExponent();
				double coeficient2=p.monom.get(indexExponent).getCoeficient();
				if(coeficient1-coeficient2!=0) {
					pNew.monom.add(new Monom(exponent2,coeficient1-coeficient2));
				}
				p.monom.remove(indexExponent);
			}
		}

		for(Monom m:p.monom) {//se adauga ce ramane in al doilea polinom cu semn schimbat
			int exponent3=m.getExponent();
			double coeficient3=m.getCoeficient();
			pNew.monom.add(new Monom(exponent3,-coeficient3));
		}
		pNew.sortareSiEliminareDuplicate();
		return pNew;
	}
	public Polinom multiply(Polinom p) {
		Polinom pNew=new Polinom();
		for(Monom m:monom) {
			for(Monom m1:p.monom) {
				Monom m2=m.inmultire(m1);
				pNew.monom.add(m2);
			}
		}
		pNew.sortareSiEliminareDuplicate();
		return pNew;
	}
	public int grad() {	//daca coeficientul nu este nul,atunci gradul polinomului este egal cu exponentul primului element din
						//lista, aceasta fiind sortata la crearea polinomului
		int g;
		if(!monom.isEmpty()) {
			for(int i=0;i<monom.size();i++) {
				if(monom.get(i).getCoeficient()!=0) {
					g=monom.get(i).getExponent();
					return g;
				}	
			}	
		}
		return 0;
	}
	public Polinom multiplyWithMonom(Monom m1) {
		Polinom pNew=new Polinom();
		for(Monom m:monom) {
			Monom m2=m.inmultire(m1);
			pNew.monom.add(m2);
		}
		pNew.sortareSiEliminareDuplicate();
		return pNew;
	}
	
	public Polinom divide(Polinom i) {
		Polinom c=new Polinom(),d = this;
		while(i.grad()<=d.grad()) {
			Monom m1=d.getMonomMax();
			Monom m2=i.getMonomMax();
			Monom m3=m1.impartire(m2);
			c.monom.add(m3);
			Polinom pAux=i.multiplyWithMonom(m3);
			d=d.subtract(pAux);
		}
		this.monom.clear();//se goleste lista de monoame a primului polinom, pentru a se putea copia restul ramas
		for(Monom m: d.monom) {
			if(d.monom.get(d.monom.indexOf(m)).getCoeficient()!=0) {
				this.monom.add(d.monom.get(d.monom.indexOf(m)));
			}
		}
		return c;
	}
	public Monom getMonomMax() {
		return this.monom.get(this.getExponentIndex(this.grad()));
	}
	public Polinom derivative() {
		Polinom pNew=new Polinom();
		for(Monom m:monom) {
			m.deriveaza();
			pNew.monom.add(m);
		}
		pNew.sortareSiEliminareDuplicate();
		return pNew;
	}
	public Polinom integrate() {
		Polinom pNew=new Polinom();
		for(Monom m:monom) {
			m.integreaza();
			pNew.monom.add(m);
		}
		pNew.sortareSiEliminareDuplicate();
		return pNew;
	}
	@Override
	public String toString() {
		String polynomialToDisplay = new String("");
		for(Monom m:monom) {
			if(m.getCoeficient()!=0) {
				if(m.getCoeficient()<0) {
					polynomialToDisplay+=(m.toString());
				}
				else {
					if(monom.indexOf(m)==0) {
						polynomialToDisplay+=(m.toString());
					}
					else {
						polynomialToDisplay+="+"+(m.toString());
					}
				}
			}
			else polynomialToDisplay+="";
		}
		return polynomialToDisplay;
	}

	public void sortareSiEliminareDuplicate() {

		Collections.sort(this.monom, Monom.comparareDupaPuteri());//sorteaza in ordine crescatoare a exponentilor
		Collections.reverse(this.monom);//inverseaza lista
		
		for(int i=0;i<monom.size()-1;i++) {//eliminare duplicate
			for(int j=i+1;j<monom.size();j++) {
				if(monom.get(i).getExponent()==monom.get(j).getExponent()) {
					monom.get(i).setCoeficient(monom.get(i).getCoeficient()+monom.get(j).getCoeficient());
					monom.remove(monom.get(j));
					j--;
				}
			}
		}
		
	}
	public int getExponentIndex(int exponent) {//indexul exponentului corespunzator din lista polinomului
		for(Monom m:monom) {
			if(m.getExponent()==exponent) {
				return monom.indexOf(m);
			}
		}
		return -1;
	}
}


