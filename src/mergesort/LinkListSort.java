/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

/**
 *
 * @author Gabe
 */
public class LinkListSort {


	public node head = null;
	public int inter = 0;
	
	node sortedMerge3(node a, node b, node c) 
	{
            inter++;
		node result = null;
		// Base cases if a list is null revert to two list mode
		if (a == null )
			return sortedMerge(b, c); 
		if (b == null)
			return sortedMerge(a, c);
                if (c == null)
			return sortedMerge(a, b);

		// Pick lowest... either a, b or c, and recur
                if(a.val <= b.val && a.val <= c.val){
                    
                        result = a;
			result.next = sortedMerge3(a.next, b, c);
                        
                
                }else if(b.val <= c.val && b.val <= a.val){
                    
                        result = b;
			result.next = sortedMerge3(a, b.next, c);
                        
                }else{
                        result = c;
			result.next = sortedMerge3(a, b, c.next);
                        
                }
		
		
		return result;

	}
	
	node sortedMerge(node a, node b) 
	{
            inter++;
		node result = null;
		// a list is empty we are done
		if (a == null)
			return b;
		if (b == null)
			return a;

		// Pick either a or b, and recur 
		if (a.val <= b.val) 
		{
			result = a;
			result.next = sortedMerge(a.next, b);
                        
		} 
		else
		{
			result = b;
			result.next = sortedMerge(a, b.next);
                        
		}
		return result;

	}

        
	node mergeSort3(node h) 
	{
	    
		// Base case : if head is null
		if (h == null || h.next == null)
		{
			return h;
		}
                
                node leftlist = get33(h);
		node nexto33 = leftlist.next;

		// set the next of middle node to null
		leftlist.next = null;

		// now I can just split this one in half
		node middle = getMiddle(nexto33);
		node last = middle.next;

		// set the next of middle node to null
		middle.next = null;

		// Apply mergeSort on left list
		node left = mergeSort(h);
                
                node mid = mergeSort(nexto33);

		// Apply mergeSort on right list
		node right = mergeSort(last);

		// Merge the left and right lists
		node sortedlist = sortedMerge3(left, mid, right);
		return sortedlist;
	}
        
	node mergeSort(node h) 
	{
	    
		// Base case : if head is null
		if (h == null || h.next == null)
		{
			return h;
		}

		// get the middle of the list
		node middle = getMiddle(h);
		node nextofmiddle = middle.next;

		// set the next of middle node to null
		middle.next = null;

		// Apply mergeSort on left list
		node left = mergeSort(h);

		// Apply mergeSort on right list
		node right = mergeSort(nextofmiddle);

		// Merge the left and right lists
		node sortedlist = sortedMerge(left, right);
		return sortedlist;
	}

	//get the middle of a linked list
	node getMiddle(node h) 
	{
		//Base case
		if (h == null)
			return h;
		node fastptr = h.next;
		node slowptr = h;
		
		// Move fastptr by two and slow ptr by one
		// Finally slowptr will point to middle node
		while (fastptr != null)
		{
			fastptr = fastptr.next;
			if(fastptr!=null)
			{
				slowptr = slowptr.next;
				fastptr=fastptr.next;
			}
		}
		return slowptr;
	}
        
        //get the first third of a linked list
        node get33(node h) 
	{
		//Base case
		if (h == null)
			return h;
		node fastptr = h.next.next;
		node slowptr = h;
		
		// Move fastptr by three and slow ptr by one
		// Finally slowptr will point to the first third node
		while (fastptr != null)
		{
			fastptr = fastptr.next;
			if(fastptr!=null)
			{
				slowptr = slowptr.next;
				fastptr=fastptr.next;
			}
		}
		return slowptr;
	}


	void push(int new_data) 
	{
		/* allocate node */
		node new_node = new node(new_data);

		/* link the old list off the new node */
		new_node.next = head;

		/* move the head to point to the new node */
		head = new_node;
	}

	// Utility function to print the linked list
	void printList(node headref) 
	{
		while (headref != null) 
		{
			System.out.print(headref.val + " ");
			headref = headref.next;
		}
	}
	

}
