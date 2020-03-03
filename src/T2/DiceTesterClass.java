/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T2;

public class DiceTesterClass {
    public static void main(String[] args) {
        
        ArrayDice<Integer> a = new ArrayDice<>(5);
        ArrayDice<Integer> b = new ArrayDice<>(4);
        a.rollDice();
        b.rollDice();
        
        LinkedListDice<Integer> c = new LinkedListDice<>(3);
        LinkedListDice<Integer> d = new LinkedListDice<>(4);
        c.rollDice();
        d.rollDice();
        
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        System.out.println(d.toString());
        
    }
}