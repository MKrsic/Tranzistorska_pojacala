/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tranzpojacnew.Tranzistori.Unipolarni;

import static java.lang.Math.sqrt;

/**
 *
 * @author MatijaKrsic
 */
public class MOSFETszsSaKond {
    
    private double udd;
    private double ugso;
    private double up;
    private double k;
    private double kmA;
    private double mi;
    private double r1;
    private double r2;
    private double rs;
    private double rD;   
    private double rt;
    private double rg;
    private double uul;
    
    private double ugg;
    private double ugsq;
    private double idq;
    private double idqmA;
    private double udsq;
    private double gm;
    private double rd;
    private double rdrD;
    private double rdrDrt;
    private double av;
    private double rul;
    private double ai;
    private double rizl;
    private double uizl;
    
    private double RdRs;
    private double uddRdRs;
    private double RdRt;
    private double idqudsq;
    private double gmmA;

    public MOSFETszsSaKond(double udd, double ugso, double k, double mi, double r1, double r2, double rs, double rD, double rt, double rg, double uul) {
        this.udd = udd;
        this.ugso = ugso;
        this.k = k;
        this.mi = mi;
        this.r1 = r1;
        this.r2 = r2;
        this.rs = rs;
        this.rD = rD;
        this.rt = rt;
        this.rg = rg;
        this.uul = uul;
        
        kmA = k/1000;
        
        ugg = (r2/(r1+r2)*udd);
        
        //postavljanje vrijednosti clanova kvadratne jednadzbe za kasnije lakse racunanje
        double a = 1;
        double b = ((2/(kmA*rs))-(2*ugso));
        double c = (ugso*ugso) - ((2*ugg)/(kmA*rs));
    
        double ugsq1 = (-b + sqrt((b*b)-(4*a*c)))/(2*a);  
        double ugsq2 = (-b - sqrt((b*b)-(4*a*c)))/(2*a);
      
        int uvijet = Double.compare(ugsq1, ugso);
        if (uvijet > 0){this.ugsq = ugsq1;}
        else {this.ugsq = ugsq2;}
        
        idq = (kmA/2) * Math.pow(ugsq-ugso, 2);
        idqmA = idq * 1000;  //zbog prikaza u mA
        udsq = udd - idq*(rD + rs);
        gm = kmA * (ugsq - ugso);
        gmmA = gm * 1000; //zbog prikaza u mA
        rd = mi/gm;
        rdrD = (rd*rD)/(rd+rD);   // rd||rD
        rdrDrt = (rdrD*rt)/(rdrD+rt);   // rd||rD||rt
        av = -gm * rdrDrt;
        rul = (r1*r2)/(r1+r2);
        ai = -av * rul/rt;
        rizl = rdrD;
        uizl = ((rul/(rul+rg)) * uul)*av;
    
        RdRs = (-1/(rD+rs)) * 1000; //mnozi se sa 1000 zbog prikaza u mA
        uddRdRs = (udd /(rD+rs)) * 1000; //mnozi se sa 1000 zbog prikaza u ma
        
        RdRt = (-1/((rD*rt)/(rD+rt))) * 1000; //mnozenje zbog mA
        idqudsq = (idq + (udsq/((rD*rt)/(rD+rt)))) * 1000; //mnozenje zbog mA
        
    }
   

    //seteri
    public void setUdd(double udd) {this.udd = udd;}

    public void setR1(double R1) {this.r1 = R1;}
    
    public void setR2(double R2) {this.r2 = R2;}
    
    public void setrD(double rD) {this.rD = rD;}

    public void setRs(double rs) {this.rs = rs;}
    
    public void setRg(double rg) {this.rg = rg;}

    public void setUgso(double ugso) {this.ugso = ugso;}

    public void setMi(double mi) {this.mi = mi;}
    
    //geteri
    public double getRul() {return rul;}

    public double getUgsq() {return ugsq;}

    public double getIdq() {return idqmA;}

    public double getUdsq() {return udsq;}

    public double getGm() {return gmmA;}

    public double getRd() {return rd;}

    public double getAv() {return av;}

    public double getAi() {return ai;}

    public double getRizl() {return rizl;}
    
    public double getUizl() {
        if(uizl >= udd) return udd;
        else return uizl;    
    }
    
    public String getSRP() {
        return "Id= " + String.format("%.2f", RdRs) + " Uds+ " +
                String.format("%.2f", uddRdRs) + " mA";
    }
    
    public String getDRP() {
        return "id= " + String.format("%.2f", RdRt) + " uds+ " +
        String.format("%.2f", idqudsq) + " mA";
    } 
    
    public double getRdRs() {return RdRs;}

    public double getUddRdRs() {return uddRdRs;}

    public double getRdRt() {return RdRt;}

    public double getIdqudsq() {return idqudsq;}
}
