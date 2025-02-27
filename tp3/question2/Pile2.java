package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        if(taille <= 0){
            capacite = PileI.CAPACITE_PAR_DEFAUT;
        }else{
            capacite = taille;
        }
        
        stk = new Stack();
    }

    // constructeur fourni
    public Pile2() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
        if(estPleine()){
            throw new PilePleineException();
        }
        stk.push(o);
    }

    public Object depiler() throws PileVideException {
        if(estVide()){
            throw new PileVideException();
        }
        return stk.pop();
    }

    public Object sommet() throws PileVideException {
        if(estVide()){
            throw new PileVideException();
        }
        return stk.peek();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        if(stk.size() == 0){
            return true;
        }
        return false;
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        if(stk.size() == capacite){
            return true;
        }
        return false;
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        String s = "[";
        for (int i = this.taille() - 1; i >= 0; i--) {
            s += this.stk.elementAt(i).toString();
            if (i > 0)
                s += ", ";
        }
        return s + "]";
    }

    public boolean equals(Object o) {
        //Stack<Object> currentStakc = this.stk;
        //Stack<Object> compareAgainstStack = ((Pile2) o).stk;
        
        //if(this.capacite != ((Pile2) o).capacite){
        //    return false;
        //}
    
        
        //for (int i = currentStakc.size() - 1; i >= 0; i--) {
        //    if (!currentStakc.pop().equals(compareAgainstStack.pop()))
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

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
        return stk.size();
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
        return capacite;
    }

} // Pile2.java
