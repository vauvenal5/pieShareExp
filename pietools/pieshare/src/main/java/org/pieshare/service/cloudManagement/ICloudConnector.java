/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.cloudManagement;

import java.util.Map;
import org.pieshare.domain.PieceOfPie;

/**
 *
 * @author vauvenal5
 */
public interface ICloudConnector
{

	public boolean connectToCloud(String cloudId, String cloudPwd);

	public Map<String, PieceOfPie> getMap();
}
