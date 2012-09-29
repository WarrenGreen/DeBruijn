package debruijn.generator;

import structures.Edge;
import structures.PositionList;
import structures.Sequence;
import structures.Vertex;

public class DeBruijnGraph extends AdjListGraph<String, String>{

	private Sequence<String> 	alphabet;
	private int 				length;
	private DTree<String> 		permTree;
	
	public DeBruijnGraph(int length, Sequence<String> alphabet) {
		super((int)Math.pow(alphabet.size(), length));
		this.length 	= length-1;
		this.alphabet 	= alphabet;
		permTree		= new DTree<String>();
	}
	
	public String genSequence() {
		return DFS(checkVertex(((LNode)vertices.first()).getNext().element()),true);
	}
	
	public String DFS(DVertex<String> w, boolean first) {
		w.put("visited", "true");
		String currElement=" ";
		if(!first) currElement = w.element();
		for(Edge<String> curr: w.getIncidentEdges()){
			
			if(((String)curr.get("visited")).compareTo("true")!=0){
				w = checkVertex(this.opposite(w, curr));
				curr.put("visited", "true");
				System.out.println(curr.element());
				return DFS(w,false).concat(currElement.substring(length>=2?1:0));
			}
		}

		return w.element().substring(length>=2?1:0);
	}
	
	public void genPermutations(){
		TNode<String> TRoot = ((TNode<String>) permTree.root());
		TRoot.setElement("root");
		populateTree(0, TRoot);
		//if(length<=2) return;
		populateGraph(TRoot, "");
		
	}
	
	public void populateTree(int depth, TNode<String> curr){
		if(depth>=length) return;
		depth++;
		
		for(int x=0;x<alphabet.size();x++){
			curr.addChild(alphabet.get(x));
			populateTree(depth, ((Sequence<TNode>)curr.getChildren()).getLast());
		}
		
		return;
	}
	
	public void populateGraph(TNode<String> curr, String perm){
		if(curr!=null&&!permTree.isRoot(curr)) perm+=curr.element();
		if(permTree.isExternal(curr)){
			//System.out.println(perm);
			this.insertVertex(perm);
			return;
		}
		
		for(int x=0;x<curr.getChildren().size();x++){
			populateGraph(((Sequence<TNode>)curr.getChildren()).get(x), perm);
		}
	
	}
	
	public Vertex<String> insertVertex(String v){
		Vertex<String> vertIn = super.insertVertex(v);
		
		//System.out.println("---------");
		for(Vertex<String> curr:vertices){
			//System.out.println(curr.element());
			if(curr.element().substring(1).compareTo(vertIn.element().substring(0, vertIn.element().length()-1))==0 ){
				this.insertDirectedEdge(curr, vertIn, curr.element()+"-->"+vertIn.element()).element();
				//System.out.println(vertIn.element()+"--"+curr.element()+"-->"+vertIn.element());
			}
			if(vertIn.element().substring(1).compareTo(curr.element().substring(0, vertIn.element().length()-1))==0 && 
					vertIn.element().compareTo(curr.element().substring(0, curr.element().length()))!=0 ){
				this.insertDirectedEdge(vertIn, curr, vertIn.element()+"-->"+curr.element());
				//System.out.println(vertIn.element()+"--"+vertIn.element()+"-->"+curr.element());
			}
		}
		
		return vertIn;
	}
	
}
