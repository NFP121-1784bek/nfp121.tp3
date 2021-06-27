package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (Pierre Abou Serhal)
 * @version (1.0)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        if (taille <= 0)
            taille = PileI.CAPACITE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }

    public Object sommet() throws PileVideException {
        if (estVide()){
            throw new PileVideException();
        }
        return this.zone[this.ptr-1];
    }

    public int capacite() {
        return this.zone.length;
    }

    public int taille() {
        return this.ptr;
    }

    public boolean estVide() {
        return ptr == 0;
    }

    public boolean estPleine() {
        return ptr == this.zone.length;
    }

    public boolean equals(Object o) {
        //  Deux piles sont égales si elles ont la même taille, même capacité, et les éléments contenus identiques
        
        //if(this.taille() != ((Pile) o).taille())
        //    return false;
            
        //if(this.capacite() != ((Pile) o).capacite())
        //    return false;
        
        //for (int i = this.ptr - 1; i >= 0; i--) {
        //    if (!this.zone[i].equals(((Pile) o).zone[i]))
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

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = this.ptr - 1; i >= 0; i--) {
            sb.append(this.zone[i].toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}