
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TableOut {

	public static int locCntr = 0;
	public static int pooltabPtr = 0;
	public static int littabPtr = 0;
	public static int symtabPtr = 0;

	public static final List<SymTab> symtab = new ArrayList<SymTab>();
	public static final List<LitTab> littab = new ArrayList<LitTab>();
	public static final List<Integer> pooltab = new ArrayList<Integer>();
	public static final List<Out> out = new ArrayList<Out>();

	static {
		pooltab.add(1);
	}

	public static void print() throws IOException {
		System.out.println("\nLocation Counter: " + locCntr);
		System.out.println("Pooltab Pointer: " + pooltabPtr);
		System.out.println("Literal Tab Pointer: " + littabPtr);
		System.out.println("Symbol Table Pointer: " + symtabPtr);
		System.out.println("\nOut");
		System.out.printf("%15s %10s %10s %10s\n", "L/c Value", "Ic for Opcode", "Op1", "Ic for op2");
		System.out.println("-----------------------------------------------");
		
		
		File f = new File("output.txt");
		BufferedWriter bw =null;
		
		for (Out m : out) {
			FileWriter fw=new FileWriter(f,true);
			bw=new BufferedWriter(fw);
			
			System.out.printf("%10s %10s %10s %10s\n", m.value, m.icOpcode, m.op1, m.ic2);
			
			bw.write(m.value+"|"+m.icOpcode+"|"+m.op1+"|"+m.ic2+"\n");
			bw.close();
			
		}
		
		
		
		
		
		
		System.out.println("\nSymbol Table");
		System.out.printf("%10s %10s %10s\n", "name", "address", "length");
		System.out.println("-----------------------------------------------");
		for (SymTab m : symtab) {
			System.out.printf("%10s %10s %10s\n", m.name, m.address, m.length);
		}
		System.out.println("\nLiteral Table");
		System.out.printf("%10s %10s %10s\n", "literal no", "literal", "address");
		System.out.println("-----------------------------------------------");
		for (LitTab m : littab) {
			System.out.printf("%10s %10s %10s\n", m.litNo, m.literal, m.address);
		}
		System.out.println("\nPool Table");
		System.out.printf("%10s\n", "Pool no");
		System.out.println("-----------------------------------------------");
		for (Integer m : pooltab) {
			System.out.printf("%10s\n", m);
		}
	}

	public static final class SymTab {
		public String name;
		public int address;
		public int length;

		public SymTab(String name, int address, int length) {
			this.name = name;
			this.address = address;
			this.length = length;
		}

		public static SymTab getByValue(String value) {
			for (SymTab p : symtab) {
				if (p.name.equals(value))
					return p;
			}
			return null;
		}

		public static String[] toArray() {
			List<String> list = new ArrayList<String>();
			for (SymTab smt : symtab) {
				if (smt.length == -1)
					list.add(smt.name);
			}
			return list.toArray(new String[list.size()]);
		}		
	}

	public static final class LitTab {
		public int litNo;
		public int literal;
		public int address;

		public LitTab(int litNo, int literal, int address) {
			this.litNo = litNo;
			this.literal = literal;
			this.address = address;
		}

		public static LitTab getByValue(int value, int no) {
			for (LitTab p : littab) {
				if (p.literal == value && p.litNo >= no)
					return p;
			}
			return null;
		}
	}

	public static final class Out {
		public int value;
		public String icOpcode;
		public int op1;
		public String ic2;

		public Out(int value, String icOpcode, int op1, String ic2) {
			this.value = value;
			this.icOpcode = icOpcode;
			this.op1 = op1;
			this.ic2 = ic2;
		}
	}
	
}
