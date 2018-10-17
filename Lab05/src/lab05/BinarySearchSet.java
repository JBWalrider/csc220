package lab05;
public class BinarySearchSet{
	public double[]storage;private int capacity,numItems;
	public BinarySearchSet(){storage=new double[capacity=6];}
	public BinarySearchSet(double[]input){double[]a=input;storage=new double[a.length];capacity=a.length;for(double d:a)binary_add(d);}
	public boolean isEmpty(){return numItems==0;}
	public int size(){return numItems;}
	public void grow(){
		int w=storage.length;
		double t[]=new double[w];
		for(int i=0;i<w;i++)t[i]=storage[i];
		storage=new double[w*2];
		for(int i=0;i<w;i++)storage[i]=t[i];
		capacity*=2;
	}
	public boolean remove(double value){
		int f=0;
		for(int i=0;i<numItems;i++){f=storage[i]==value?1:f;if(f>0)storage[i]=storage[i+1];}
		return f>0?0<numItems--:1<0;
	}
	public boolean sequential_add(double newVal){
		int n=numItems;double e=newVal;if(n==capacity)grow();
		for(int i=0;i<=n;i++){
			double q=storage[i];
			if(q==0.0){storage[i]=e;break;}
			if(q==e)return q>e;
			if(q>e){storage[i]=e;e=q;}
		}return n==numItems++;
	}
	public boolean binary_add(double newVal){
		int t=numItems;if(t==capacity)grow();double v=newVal;int a=0,z=t-1,n;
		for(;;){
			n=(z+a)/2;double w=storage[n];
			if(z<=a){
				if(w==0.0){storage[n]=v;break;}if(w==v)return w>v;if(w<v)n++;
				for(int i=t;i>n;i--)storage[i]=storage[i-1];storage[n]=v;break;
			}z=v<w?n-1:z+(a=n+1)-a;
		}return t==numItems++;
	}
	public boolean contains(double value){
		int a=0,m=0,z=numItems-1;
		for(;;){
			z=value<storage[m=(z+a)/2]?m-1:z+0*(a=m+1);
			if(value==storage[m]|a>z)return value==storage[m];
		}
	}
	public boolean containsAll(double[]elements){int f=1;for(double d:elements)f=contains(d)?f:0;return f>0;}
	public void clear() {for(double d:storage)d=0.0;}
	public String toString(){return"";} //shortest possible without errors, not for testing use
}
	//public String toString(){String s="";for(double d:storage)s+=(d+",");s+=(capacity+","+numItems);return s;} //for testing


/*
  	contains old ideas, compare:

  	if(v==storage[m])return 0<1;if(a>z)return 1<0;
	if(v==storage[m]|a>z)return v==storage[m];

  	m=(z+a)/2;if(value<storage[m])z=m-1;else a=m+1;
	m=(z+a)/2;z=value<storage[m]?m-1:z+0*(a=m+1);
	z=value<storage[m=(z+a)/2]?m-1:z+0*(a=m+1);
	
	containsAll old ideas, compare:
	
	int f=1;for(double d:elements)if(!contains(d))f=0;return f>0;
	boolean f=0<1;for(double d:elements)f&=contains(d);return f;
	int f=1;for(double d:elements)f*=contains(d)?1:0;return f>0;
	int f=1;for(double d:elements)f=contains(d)?f:0;return f>0;
	
	remove old ideas, compare:
	
    boolean f=0>1;for(int i=0;i<numItems;i++){f=storage[i]==value?0<1:f;if(f)storage[i]=storage[i+1];}if(f)numItems--;return f;
    int f=0;for(int i=0;i<numItems;i++){f=storage[i]==value?1:f;if(f>0)storage[i]=storage[i+1];}return f>0?0<numItems--:1<0;
*/

//ungolfed:
	/*
	    public boolean sequential_add(double newVal) {
			int n = numItems; //shorten references, allow quickreturn
			double e = newVal; //shorten references, allow quickswap later
			if (n == capacity) {
				grow();
			}
			for (int i = 0; ++i <= n; i++) {
				double q = storage[i];
				if (q == 0.0) {
					storage[i] = e;
					break;
				}
				if (q == e) {
					return q>e; //false
				}
				if (q > e) {
					storage[i] = e; e = q; //quickswap with already assigned temp var
				}
			}
			return n == numItems++; //quickreturn: numItems++; return true;
		}
		
	public boolean binary_add(double newVal) {
		int t = numItems;
		double v = newVal;
		if (t == capacity) {
			grow();
		}
	    int a = 0, z = t-1, n;
		for(;;) { //shorter than while(1>0) or while(true)
			n = (z + a) / 2;
			double w = storage[n];
			if (z <= a) {
				if (w == 0.0) {
					storage[n] = v;break;
				}
                if (w == v) { //w and storage[n] still same b/c all cases where they are different have already break; out of loop
                	return w>v;
                }
				if (w < v) { //w and storage[n] still same b/c all cases where they are different have already break; out of loop
					n++;
				}
				for (int i = t; i > n; i--) {
					storage[i] = storage[i-1];
				}
				// same length
				// for(int i=t;i>n;i--)storage[i]=storage[i-1];
				// for(int i=t;--i>=n;)storage[i+1]=storage[i];
				storage[n] = v;
				break;
			}
			z = v < w ? n - 1 : z + (a = n + 1) - a;
			//if(v<w)z=n-1;else a=n+1; //same, but 2b longer
			//z=v<w?n-1:z+(a=n+1)-a;
			else {
				a = n+1;
			}
		}
        return t == numItems++; //numItems++; return true;
	}
 */
