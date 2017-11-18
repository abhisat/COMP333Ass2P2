package jury;

import java.util.ArrayList;

public class Jury_Pool1 {
int initialSize = 0;
int juryPoolSize = 0;
int[] juryPoolList;

/*In the constructor below a string is passed as parameter to first 
 * The variable "initialSize" represents the size of the initial list of candidates.
 * The variable "juryPoolSize" is the size of the final pool of potential jurors without any 'relationship' 
 * in the first sense. This number is unique for a given input list of candidates. 
 * The variable "juryPoolList" is an integer array containing a list of potential juror id's. These lists 
 * can vary. But of course they must all satisfy the basic criterion that there is no 'relationship' 
 * (in the first sense) between any pair. 
 * The class JuryGraph represents the basic graph of direct relations. 
 */


public Jury_Pool1(String s) {
	JuryGraph candidateRelation = new JuryGraph(s);

	/*
	 The string 's' represents the path to the input file. This part 
	 has been implemented.
	 */

	initialSize = candidateRelation.graph_Size;
	juryPoolSize = calcPoolsize(candidateRelation);
	juryPoolList = calcPoolList(candidateRelation);
}
int calcPoolsize(JuryGraph jG) {
	int poolSize = 0;

	ArrayList<Candidate> poolList = new ArrayList<>();
	ArrayList<Candidate> rejectedPoolList = new ArrayList<>();

	for (Candidate x : jG.candidate_List.subList(1, jG.candidate_List.size())){
		if (!(rejectedPoolList.contains(x))){
			poolList.add(x);
			rejectedPoolList.addAll(bfsTree(x));
		}
		poolSize = poolList.size();
	}

	
	/*Your code goes here. 
	The variable poolSize is given as a suggestion. You are free to change it if you wish.
	Of course you have to return some variable of integer type. It has been initialized to 0.  
	Note: 0 is not an acceptable value for the jury pool size. 
	You can write any other classes and methods 
	to help you calculate. 
	*/

	return poolSize;
}

ArrayList<Candidate> bfsTree(Candidate candidate) {
	ArrayList<Candidate> tmp = new ArrayList<>();
	ArrayList<Candidate> visited = new ArrayList<>();
	ArrayList<Candidate> queue = new ArrayList<>();
	Candidate s;

	visited.add(candidate);
	queue.add(candidate);
	while (!(queue.size() == 0)) {
		s = queue.remove(0);
		for (Candidate m : s.adj_List) {
			if (!(visited.contains(m))) {
				visited.add(m);
				for (Candidate a : s.adj_List){
					if(!(queue.contains(a))){
						queue.add(a);
					}
				}

				tmp.add(m);
			}
		}

	}

	return tmp;
}
int[] calcPoolList(JuryGraph jG) {
	int[] poolList = new int[juryPoolSize];
	/*Your code goes here. 
	 * We have an integer array poolList. To create this array you will have to calculate 
	 * juryPoolSize first. You can change it. But make sure the function returns an array 
	 * of integers that represents an acceptable jury pool. 
	 * It is suggested that you create some classes and methods of your own and call them here. This 
	 * method and the one preceding can be considered 'wrapper' methods. 
	 */
	ArrayList<Candidate> pool = new ArrayList<>();
	ArrayList<Candidate> rejectedPoolList = new ArrayList<>();

	for (Candidate x : jG.candidate_List.subList(1, jG.candidate_List.size())){
		if (!(rejectedPoolList.contains(x))){
			pool.add(x);
			rejectedPoolList.addAll(bfsTree(x));
		}
	}

	for (int i = 0; i < juryPoolSize; i++){
		poolList[i] = pool.get(i).id;
	}
	return poolList;
}
}
