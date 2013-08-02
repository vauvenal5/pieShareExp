/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.filewatcher;

import java.util.List;
import org.pieshare.domain.PieceOfPie;

/**
 *
 * @author richy
 */
public interface IFolderContentReader
{
	List<PieceOfPie> getFolderContent();
}
