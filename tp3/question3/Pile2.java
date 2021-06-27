package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
        if(taille <= 0){
            capacite = PileI.CAPACITE_PAR_DEFAUT;
        }else{
            capacite = taille;
        }
        
        stk = new Stack();
    }

    public Pile2(){
        this(0);
    }

    public void empiler(T o) throws PilePleineException{
        if(estPleine()){
            throw new PilePleineException();
        }
        stk.push(o);
    }

    public T depiler() throws PileVideException{
        if(estVide()){
            throw new PileVideException();
        }
        return stk.pop();
    }

    public T sommet() throws PileVideException{
        if(estVide()){
            throw new PileVideException();
        }
        return stk.peek();
    }
    
    public boolean estPleine(){
        if(stk.size() == capacite){
            return true;
        }
        return false;
    }
    
    public int capacite(){
        return capacite;
    }
    
    public int taille(){
        return stk.size();
    }
    
    public boolean estVide(){
        if(stk.size() == 0){
            return true;
        }
        return false;
    }
    
    public boolean equals(Object o){
        Stack<T> currentStakc = this.stk;
        Stack<T> compareAgainstStack = ((Pile2) o).stk;
        
        if(this.capacite != ((Pile2) o).capacite){
            return false;
        }
    
        
        for (int i = currentStakc.size() - 1; i >= 0; i--) {
            if (!currentStakc.pop().equals(compareAgainstStack.pop()))
                return false;
        }
        
        return true;
    }
    
    public int hashCode(){
        return toString().hashCode();
    }
    
    public String toString(){
        String s = "[";
        for (int i = this.taille() - 1; i >= 0; i--) {
            s += this.stk.elementAt(i).toString();
            if (i > 0)
                s += ", ";
        }
        return s + "]";
    }
    

} // Pile2