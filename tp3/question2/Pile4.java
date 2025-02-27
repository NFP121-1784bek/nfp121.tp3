package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {
    /** la liste des Maillons/Elements */
    private Maillon stk;
    /** la capacit� de la pile */
    private int capacite;
    /** le nombre */
    private int nombre;

    /**
     * Classe interne "statique" contenant chaque �l�ment de la chaine c'est une
     * proposition, vous pouvez l'ignorer !
     */
    private static class Maillon implements Cloneable {
        private Object element;
        private Maillon suivant;

        public Maillon(Object element, Maillon suivant) {
            this.element = element;
            this.suivant = suivant;
        }

        public Maillon suivant() {
            return this.suivant;
        }

        public Object element() {
            return this.element;
        }

        public Object clone() throws CloneNotSupportedException {
            Maillon m = (Maillon) super.clone();
            m.element = element;
            return m;
        }
    }

    /**
     * Cr�ation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit �tre > 0
     */
    public Pile4(int taille) {
        if (taille <= 0)
            taille = PileI.CAPACITE_PAR_DEFAUT;
        this.stk = null;
        this.capacite = taille;
    }

    public Pile4() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        Maillon sommet = new Maillon(o, this.stk);
        this.stk = sommet;
        nombre++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        Maillon tempararyStack = this.stk;
        this.stk = this.stk.suivant();
        nombre--;
        return tempararyStack.element();
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
         return this.stk.element();
    }

    /**
     * Effectue un test de l'�tat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return this.stk == null;
    }

    /**
     * Effectue un test de l'�tat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return this.nombre == this.capacite;
    }

    /**
     * Retourne une repr�sentation en String d'une pile, contenant la
     * repr�sentation en String de chaque �l�ment.
     * 
     * @return une repr�sentation en String d'une pile
     */
    public String toString() {

        String s = "[";
        Maillon tempararyStack = this.stk;
        
        for(int i = 0 ;i < this.nombre;i++){
            if(i > 0 && i < this.nombre){
                s += ", ";
            }
            s += tempararyStack.element().toString();
            
            tempararyStack = tempararyStack.suivant();
        } 
        return s + "]";
    }

    public boolean equals(Object o) {
            
        //if(this.capacite() != ((Pile4)o).capacite() || this.taille() != ((Pile4)o).taille())
        //    return false;
            
        //Maillon temp = this.stk;
        //Maillon temp1 = ((Pile4)o).stk;
        
        //while(temp != null){
            
        //    if(!temp.element().equals(temp1.element()))
        //        return false;
    
        //    temp = temp.suivant();
        //    temp1 = temp1.suivant();
        //}
        //return true;
        
        if (o instanceof PileI) {
          PileI p = (PileI) o;
          return this.capacite() == p.capacite()
              && this.hashCode() == p.hashCode();
        } else
        
      return false; 
                
    }

    public int capacite() {
        return this.capacite;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int taille() {
        return nombre;
    }
}