package lab02;

public class Matrix {
	int numRows;
	int numColumns;
	int data[][];
	
	// default constructor
	public Matrix(){}
	
	// constructor 1 - Constructor for new zero matrix
	public Matrix(int rowDim, int colDim) {
		numRows = rowDim;
		numColumns = colDim;
		data = new int[rowDim][colDim];
		for (int i = 0; i < rowDim; i++) {
			for (int j = 0; j < colDim; j++) {
				data[i][j] = 0;
			}
		}
	}
	
	
	// constructor 2 - Constructor with data for new matrix (automatically determines dimensions)
	public Matrix(int d[][])
	{
		numRows = d.length;
		numColumns = d[0].length;
    	data = new int[numRows][numColumns];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				data[i][j] = d[i][j];
			}
		}
	}	
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public String toString() {
		String str = "\n";
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				str += data[i][j] + " ";
			}
			str += "\n";
		}
		return str;
	}
	// *** you will implement the rest of the methods for your assignment
	// *** don't touch them before finishing the lab portion
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public boolean equals(Object o)
	{
		if(!(o instanceof Matrix)) // make sure the Object we're comparing to is a Matrix
			return false;
		Matrix m = (Matrix)o; // if the above was not true, we know it's safe to treat 'o' as a Matrix
	    if (m.data.length == data.length && m.data[0].length == data[0].length) {
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numColumns; j++) {
                    if (m.data[i][j] != data[i][j]) {
                        return false;
                    }
                }
            }
        }
        else return false;
		return true; // placeholder
	}

	public Matrix times(Matrix m)
	{
		
        Matrix n = new Matrix(numRows,m.numColumns);
		if (numColumns == m.numRows) {
            int t = 0;
            for (int i = 0; i < n.numRows; i++) {
                for (int j = 0; j < n.numColumns; j++) {
                    t = 0;
                    for (int k = 0; k < numColumns; k++) {
                        t += data[i][k]*m.data[k][j];
                    }
                    n.data[i][j] = t;
                }
            }
        }
        else return null;
        return n;
    }	

	
	public Matrix plus(Matrix m)
	{
        Matrix n = new Matrix(data);
		if (m.data.length == n.data.length && m.data[0].length == n.data[0].length) {
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numColumns; j++) {
                    n.data[i][j] += m.data[i][j];
                }
            }
        }
        else return null;
        return n;
	}	
}
