/*******************************************************************************
 * Copyright C 2015, The Pistoia Alliance
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package org.helm.ChemistryToolkit;

import java.io.IOException;

import org.helm.chemtoolkit.CTKException;
import org.helm.chemtoolkit.ChemicalToolKit;
import org.helm.chemtoolkit.ChemistryManipulator;
import org.helm.chemtoolkit.MoleculeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

import bsh.Console;

/**
 * @author chistyakov
 *
 */
public class CDKTest {
	private static String type = "CDK";

	@Test
	public void validateSMILESTest() throws CTKException {
		boolean res = false;
		// String smiles =
		// "CCc1nn(C)c2c(=O)[nH]c(nc12)c3cc(ccc3OCC)S(=O)(=O)N4CCN(C)CC4";
		String smiles = "[$([#6])]C1=C([$(C=O),$([#7])])C=CC=C1[$(C=O),$([#7])] |$_R1;;;_R2;;;;;_R2$,c:1,4,6|";
		ChemistryManipulator manipulator = ChemicalToolKit.getTestINSTANCE(type).getManipulator();
		res = manipulator.validateSMILES(smiles);
		Assert.assertEquals(res, true);

	}

	@Test
	public void getMoleculeInfoTest() throws CTKException {
		String smiles = "CCc1nn(C)c2c(=O)[nH]c(nc12)c3cc(ccc3OCC)S(=O)(=O)N4CCN(C)CC4";
		ChemistryManipulator manipulator = ChemicalToolKit.getINSTANCE().getManipulator();
		MoleculeInfo moleculeInfo = manipulator.getMoleculeInfo(smiles);
		System.out.println("molecular weight=" + moleculeInfo.getMolecularWeight());
		System.out.println("exact mass=" + moleculeInfo.getExactMass());
		System.out.println("sum formula=" + moleculeInfo.getMolecularFormula());
		Assert.assertEquals(moleculeInfo.getMolecularFormula(), "C21H28N6O4S");

	}

	@Test
	public void convertSMILES2MolFile() throws CTKException, Exception {
		String smiles = "CCc1nn(C)c2c(=O)[nH]c(nc12)c3cc(ccc3OCC)S(=O)(=O)N4CCN(C)CC4";
		ChemistryManipulator manipulator = ChemicalToolKit.getINSTANCE().getManipulator();
		String molFile = manipulator.convertSMILES2MolFile(smiles);
		System.out.println("molFile=" + molFile);

	}

	@Test
	void convertMolFile2SMILES() throws CTKException, IOException {
		String molFile = "\n" + "  ACCLDraw11131512172D\n" + "\n" + " 32 35  0  0  0  0  0  0  0  0999 V2000\n"
				+ "    7.6862   -7.0367    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "    6.6485   -6.4506    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "    5.6213   -4.6864    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "    6.6485   -5.2695    0.0000 N   0  0  3  0  0  0  0  0  0  0  0  0\n"
				+ "    7.6653   -4.6687    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "    8.7132   -5.2548    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "    8.7132   -6.4417    0.0000 N   0  0  3  0  0  0  0  0  0  0  0  0\n"
				+ "   10.3235   -5.9976    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "    9.1573   -8.0519    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "    9.7404   -7.0246    0.0000 S   0  0  3  0  0  0  0  0  0  0  0  0\n"
				+ "   15.8922   -9.3677    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "   14.8676   -8.7801    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "   13.8465   -9.3736    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "   12.8167   -8.7860    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "   11.7999   -9.3781    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "   10.7675   -8.7950    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "   10.7675   -7.6078    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "   11.7895   -7.0036    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "   12.8167   -7.5988    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "   15.8892   -7.0083    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "   14.8640   -7.5949    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "   13.8388   -7.0068    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "   13.8388   -5.8189    0.0000 N   0  0  3  0  0  0  0  0  0  0  0  0\n"
				+ "   14.8640   -4.0379    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "   14.8640   -5.2190    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "   15.8892   -5.8189    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "   17.3854   -4.3283    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "   17.0205   -5.4515    0.0000 N   0  0  3  0  0  0  0  0  0  0  0  0\n"
				+ "   17.7197   -6.4137    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "   17.0205   -7.3760    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "   17.3853   -8.4994    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n"
				+ "   18.5407   -8.7449    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" + "  2  1  1  0  0  0  0\n"
				+ "  4  2  1  0  0  0  0\n" + "  4  3  1  0  0  0  0\n" + "  5  4  1  0  0  0  0\n"
				+ "  6  5  1  0  0  0  0\n" + "  7  6  1  0  0  0  0\n" + "  7  1  1  0  0  0  0\n"
				+ " 10  7  1  0  0  0  0\n" + " 10  8  2  0  0  0  0\n" + " 10  9  2  0  0  0  0\n"
				+ " 17 10  1  0  0  0  0\n" + " 12 11  1  0  0  0  0\n" + " 13 12  1  0  0  0  0\n"
				+ " 14 13  1  0  0  0  0\n" + " 15 14  1  0  0  0  0\n" + " 16 15  2  0  0  0  0\n"
				+ " 17 16  1  0  0  0  0\n" + " 18 17  2  0  0  0  0\n" + " 19 18  1  0  0  0  0\n"
				+ " 19 14  2  0  0  0  0\n" + " 22 19  1  0  0  0  0\n" + " 21 20  1  0  0  0  0\n"
				+ " 22 21  2  0  0  0  0\n" + " 23 22  1  0  0  0  0\n" + " 25 23  1  0  0  0  0\n"
				+ " 25 24  2  0  0  0  0\n" + " 26 25  1  0  0  0  0\n" + " 26 20  2  0  0  0  0\n"
				+ " 28 26  1  0  0  0  0\n" + " 28 27  1  0  0  0  0\n" + " 29 28  1  0  0  0  0\n"
				+ " 30 29  2  0  0  0  0\n" + " 30 20  1  0  0  0  0\n" + " 31 30  1  0  0  0  0\n"
				+ " 32 31  1  0  0  0  0\n" + "M  END";

		ChemistryManipulator manipulator = ChemicalToolKit.getINSTANCE().getManipulator();
		String result = manipulator.convertMolFile2SMILES(molFile);
		System.out.println(result);

	}

}
