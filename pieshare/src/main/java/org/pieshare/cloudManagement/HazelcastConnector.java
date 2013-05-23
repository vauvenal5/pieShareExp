/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.cloudManagement;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import java.util.Map;
import org.pieshare.common.PieceOfPie;

/**
 *
 * @author vauvenal5
 */
public class HazelcastConnector implements ICloudConnector
{

    private Map<String, PieceOfPie> cloudMap;
    private String mapName = "pieCloud";
    
    public boolean connectToCloud(String cloudId, String cloudPwd) 
    {
        HazelcastInstance instance = Hazelcast.getHazelcastInstanceByName(mapName);
        
        if(instance == null)
        {
            Config config = new Config();
            config.setInstanceName(cloudId);
            instance = Hazelcast.newHazelcastInstance(config);
        }
        
        this.cloudMap = instance.getMap(this.mapName);
        
        return true;
    }

    public Map<String, PieceOfPie> getMap() 
    {
        return this.cloudMap;
    }
    
    
}
