package hgaddon.ibieel;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import utilities.BGKit;


public class Main extends JavaPlugin implements Listener{


	public void onEnable(){
		BGKit.setAbilityDesc(1000, "Jogar teia nos inimigos");
		BGKit.setAbilityDesc(1001, "Escalar blocos");
		BGKit.setAbilityDesc(1002, "Mais forte com machado");
		BGKit.setAbilityDesc(1003, "Coloca fogo nos inimigos em volta");
		BGKit.setAbilityDesc(1004, "Respirar em baixo d'agua");
		BGKit.setAbilityDesc(1005, "Mais forte em baixo d'agua");
		BGKit.setAbilityDesc(1006, "Voar por 5 segundos");
		BGKit.setAbilityDesc(1007, "Permite teleportar jogadores até você");
		BGKit.setAbilityDesc(1008, "Joga inimigos para cima");
		getServer().getPluginManager().registerEvents(new Kits(this), this);
		

	}

	public void onDisable(){

	}





}
