package com.example.hp.individual;

public class UserModel {
    int id;
    String date;
    String drug;
    String symtop;
    String treatment;

    public int getId() {
        return id;
    }
    public void setid(int id){
        this.id = id;
    }

    public CharSequence getDate(){
    return date;
    }
    public void setdate(String date) {
        this.date = date;
    }

    public String getDrug() {
        return drug;
    }
    public void setDrug(String drug ){
        this.drug = drug;
    }

    public String getSymtop(){
        return symtop;
    }
    public void setSymtop(String symtop){
        this.symtop = symtop;
    }

    public String getTreatment(){
        return treatment;
    }
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

  @Override
  public String toString(){
        return getDate()+"\n"
                +getDrug()+"\n"
                +getSymtop()+"\n"
                +getTreatment();
  }

}
