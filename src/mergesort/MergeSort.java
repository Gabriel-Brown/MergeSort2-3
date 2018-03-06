/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.util.Random;

/**
 *
 * @author Gabe
 */
public class MergeSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        	

		LinkListSort li = new LinkListSort();
                LinkListSort li3 = new LinkListSort();

		Random rn = new Random();
		
		for (int i = 0; i < 1000; i++)
		{
                    int rnum = rn.nextInt(10000);
		    li.push(rnum);
                    li3.push(rnum);
		}
		
		
		
		System.out.println("Linked List without sorting is :");
             
		li.printList(li.head);

		// normal merge Sort
                final long startTime1 = System.currentTimeMillis();
                li.head = li.mergeSort(li.head);
                final long endTime1 = System.currentTimeMillis();
		System.out.print("\n\nMergeSorted Linked List is: \n");
		li.printList(li.head);
		System.out.print("\n" + li.inter + " interations needed\n");
                
                System.out.println("Total execution time in mils: " + (endTime1 - startTime1) + "\n" );
		
                


		// 3-way merge Sort
                final long startTime2 = System.currentTimeMillis();
                li3.head = li3.mergeSort3(li3.head);
                final long endTime2 = System.currentTimeMillis();
		
		System.out.print("\nThree-way Merge Sorted Linked List is: \n");
		li3.printList(li3.head);
		System.out.print("\n" + li3.inter + " interations needed\n");
                System.out.println("Total execution time in mils: " + (endTime1 - startTime1) + "\n" );
    }
    
}
