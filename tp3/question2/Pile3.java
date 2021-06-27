package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (Pierre Abou Serhal)
 * @version (1.0)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;

    public Pile3() {
        this(0);
    }

    public Pile3(int taille) {

        if(taille <= 0)
            taille = PileI.CAPACITE_PAR_DEFAUT;
        
        v = new Vector<Object>(taille);
    }

    public void empiler(Object o) throws PilePleineException {
        if(estPleine())
            throw new PilePleineException();
        
        this.v.addElement(o);
    }

    public Object depiler() throws PileVideException {
        if(estVide())
            throw new PileVideException();
        
        return this.v.remove(this.taille() - 1);
    }

    public Object sommet() throws PileVideException {
        return this.v.lastElement();
    }

    public int taille() {
        return this.v.size();
    }

    public int capacite() {
        return this.v.capacity();
    }

    public boolean estVide() {
        return this.taille() == 0;
    }

    public boolean estPleine() {
        return this.taille() == this.capacite();
    }

    public String toString() {
         String s = "[";

        for (int i = this.taille() - 1; i >= 0; i--) {
            s += this.v.elementAt(i).toString();
            if (i > 0)
                s += ", ";
        }
        return s + "]";
    }

    public boolean equals(Object o) {
        
        //if (this.capacite() != ((Pile3)o).capacite())
        //    return false;
        
        //if (this.taille() != ((Pile3)o).taille())
        //    return false;
            
        //for(int i =0;i < this.taille();i++){
        //    if(!this.v.elementAt(i).equals(((Pile3)o).v.elementAt(i)))
        //        return false;
        //}
        
        //return true;
        
        if (o instanceof PileI) {
          PileI p = (PileI) o;
          return this.capacite() == p.capacite()
              && this.hashCode() == p.hashCode();
        } else
      return false; 
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}