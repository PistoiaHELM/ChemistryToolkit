/*******************************************************************************
 * Copyright C 2015, The Pistoia Alliance
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package org.helm.chemstrytoolkit.chemaxon;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.helm.chemistrytoolkit.TestBase;
import org.helm.chemtoolkit.CTKException;
import org.helm.chemtoolkit.CTKSmilesException;
import org.helm.chemtoolkit.ManipulatorFactory;
import org.helm.chemtoolkit.ManipulatorFactory.ManipulatorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * @author chistyakov
 *
 */
public class ChemaxonTest extends TestBase {

  private static final Logger LOG = LoggerFactory.getLogger(ChemaxonTest.class);

  @BeforeSuite(groups = {"MarvinTest"})
  public void initialize() throws CTKException {

    try {
      LOG.debug("initialize");
      manipulator = ManipulatorFactory.buildManipulator(ManipulatorType.MARVIN);
    } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
        | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
      throw new CTKException("unable to invoke a manipulator");
    }
  }

  @Override
  @Test(groups = {"MarvinTest"})
  public void validateSMILESTest() throws CTKException {
    super.validateSMILESTest();
  }

  @Override
  @Test(groups = {"MarvinTest"})
  public void getMoleculeInfoTest() throws CTKException, IOException {
    super.getMoleculeInfoTest();
    Assert.assertEquals(testResult, "C21H28N6O4S");

  }

  @Override
  @Test(groups = {"MarvinTest"})
  public void convertSMILES2MolFile() throws CTKException, Exception {
    super.convertSMILES2MolFile();
    LOG.debug(testResult);

  }

  @Override
  @Test(groups = {"MarvinTest"})
  public void convertMolFile2SMILES() throws CTKException, IOException {
    super.convertMolFile2SMILES();
    LOG.debug("canonical=" + testResult);
    Assert.assertEquals(testResult, "Nc1ncnc2n(cnc12)[C@@H]1O[C@H](CO*)[C@@H](O*)[C@H]1O");

  }

  @Override
  @Test(groups = {"MarvinTest"})
  public void canonicalizeTest() throws CTKSmilesException, CTKException {
    super.canonicalizeTest();
    Assert.assertEquals(testResult, "CCOc1ccc(cc1-c1nc2c(CC)nn(C)c2c(=O)[nH]1)S(=O)(=O)N1CCN(C)CC1");

  }

  @Override
  @Test(groups = {"MarvinTest"})
  public void renderMolTest() throws CTKException, IOException {
    super.renderMolTest();
  }


  @Override
  @Test(groups = {"MarvinTest"})
  public void createGroupMolFile() throws CTKException, IOException {
    super.createGroupMolFile();
    LOG.debug(testResult);
  }

  @Override
  @Test(groups = {"MarvinTest"})
  public void adeninRiboseMerge() throws IOException, CTKException {
    super.adeninRiboseMerge();
    LOG.debug(testResult);
  }

  @Override
  @Test(groups = {"MarvinTest"})
  public void mergeTest() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
      InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException,
      CTKException {
    super.mergeTest();
    LOG.debug(testResult);

  }

  @Override
  @Test(groups = {"MarvinTest"})
  public void getRibose() throws IOException, CTKException {
    super.getRibose();
    Assert.assertEquals(testResult, "[H]OC[C@H]1O[C@H](O)[C@H](O)[C@@H]1O[H]");
  }

  @Override
  @Test(groups = {"MarvinTest"})
  public void aaMerge() throws IOException, CTKException {
    super.aaMerge();
  }

  @Override
  @Test(groups = {"MarvinTest"})
  public void mergePhosphatRiboseTest() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
      InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException,
      CTKException {
    super.mergePhosphatRiboseTest();
    LOG.debug(testResult);
  }

}