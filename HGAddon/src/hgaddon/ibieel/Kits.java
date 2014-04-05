package hgaddon.ibieel;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import utilities.BGKit;

public class Kits extends JavaPlugin implements Listener {

	public Main plugin;
	public Kits(Main plugin){
		this.plugin = plugin;
	}
	
	
	
	
	
	
	//homem aranha - iBieel/Smooph(Teia) -- Grigo(Escalar paredes)
	public static ArrayList<Integer> noVineBlocks = new ArrayList<>();
	
	/*
	 * Blocos que não dão para escalar
	 */
	public void defineNoVineBlocks() {
		noVineBlocks.add(Integer.valueOf(Material.THIN_GLASS.getId()));
		noVineBlocks.add(Integer.valueOf(44));
		noVineBlocks.add(Integer.valueOf(126));
		noVineBlocks.add(Integer.valueOf(Material.WOOD_STAIRS.getId()));
		noVineBlocks.add(Integer.valueOf(Material.JUNGLE_WOOD_STAIRS.getId()));
		noVineBlocks.add(Integer.valueOf(Material.BIRCH_WOOD_STAIRS.getId()));
		noVineBlocks.add(Integer.valueOf(Material.SPRUCE_WOOD_STAIRS.getId()));
		noVineBlocks.add(Integer.valueOf(Material.COBBLESTONE_STAIRS.getId()));
		noVineBlocks.add(Integer.valueOf(Material.BRICK_STAIRS.getId()));
		noVineBlocks.add(Integer.valueOf(Material.WOOD_STAIRS.getId()));
		noVineBlocks.add(Integer.valueOf(Material.SMOOTH_STAIRS.getId()));
		noVineBlocks.add(Integer.valueOf(Material.NETHER_BRICK_STAIRS.getId()));
		noVineBlocks.add(Integer.valueOf(Material.SANDSTONE_STAIRS.getId()));
		noVineBlocks.add(Integer.valueOf(Material.FENCE.getId()));
		noVineBlocks.add(Integer.valueOf(Material.FENCE_GATE.getId()));
		noVineBlocks.add(Integer.valueOf(Material.NETHER_FENCE.getId()));
		noVineBlocks.add(Integer.valueOf(Material.LADDER.getId()));
		noVineBlocks.add(Integer.valueOf(Material.VINE.getId()));
		noVineBlocks.add(Integer.valueOf(Material.BED.getId()));
		noVineBlocks.add(Integer.valueOf(Material.BED_BLOCK.getId()));
		noVineBlocks.add(Integer.valueOf(Material.IRON_FENCE.getId()));
		noVineBlocks.add(Integer.valueOf(Material.SNOW.getId()));
		noVineBlocks.add(Integer.valueOf(Material.SIGN.getId()));
		noVineBlocks.add(Integer.valueOf(Material.LEVER.getId()));
		noVineBlocks.add(Integer.valueOf(Material.TRAP_DOOR.getId()));
		noVineBlocks.add(Integer.valueOf(Material.PISTON_EXTENSION.getId()));
		noVineBlocks.add(Integer.valueOf(Material.PISTON_MOVING_PIECE.getId()));
		noVineBlocks.add(Integer.valueOf(Material.TRIPWIRE_HOOK.getId()));
		noVineBlocks.add(Integer.valueOf(93));
		noVineBlocks.add(Integer.valueOf(94));
		noVineBlocks.add(Integer.valueOf(Material.BOAT.getId()));
		noVineBlocks.add(Integer.valueOf(Material.MINECART.getId()));
		noVineBlocks.add(Integer.valueOf(Material.CAKE.getId()));
		noVineBlocks.add(Integer.valueOf(Material.CAKE_BLOCK.getId()));
		noVineBlocks.add(Integer.valueOf(Material.WATER.getId()));
		noVineBlocks.add(Integer.valueOf(Material.STATIONARY_WATER.getId()));
		noVineBlocks.add(Integer.valueOf(Material.LAVA.getId()));
		noVineBlocks.add(Integer.valueOf(Material.STATIONARY_LAVA.getId()));
	}

	List<String> DelaySnowball = new ArrayList<String>();
	@EventHandler
	public void SpiderManTeia(ProjectileHitEvent e){
		final Player player = (Player) e.getEntity().getShooter();
		if(BGKit.hasAbility(player, Integer.valueOf(1000)).booleanValue()){

			Entity entity = e.getEntity();
			if (entity instanceof Snowball) {
				if(!(DelaySnowball.contains(player.getName()))){
					DelaySnowball.add(player.getName());
					Block loc = e.getEntity().getLocation().getBlock();
					if(loc.getType() == Material.AIR){
						loc.setType(Material.WEB);
					}
					if(loc.getRelative(BlockFace.EAST).getType() == Material.AIR){
						loc.getRelative(BlockFace.EAST).setType(Material.WEB);
					} 
					if(loc.getRelative(BlockFace.NORTH).getType() == Material.AIR){
						loc.getRelative(BlockFace.NORTH).setType(Material.WEB);
					}
					if(loc.getRelative(BlockFace.SOUTH).getType() == Material.AIR){
						loc.getRelative(BlockFace.SOUTH).setType(Material.WEB);
					}
					if(loc.getRelative(BlockFace.WEST).getType() == Material.AIR){
						loc.getRelative(BlockFace.WEST).setType(Material.WEB);
					}
					if(loc.getRelative(BlockFace.WEST).getRelative(BlockFace.NORTH).getType() == Material.AIR){
						loc.getRelative(BlockFace.WEST).getRelative(BlockFace.NORTH).setType(Material.WEB);
					}
					if(loc.getRelative(BlockFace.WEST).getRelative(BlockFace.SOUTH).getType() == Material.AIR){
						loc.getRelative(BlockFace.WEST).getRelative(BlockFace.SOUTH).setType(Material.WEB);
					}
					if(loc.getRelative(BlockFace.EAST).getRelative(BlockFace.NORTH).getType() == Material.AIR){
						loc.getRelative(BlockFace.EAST).getRelative(BlockFace.NORTH).setType(Material.WEB);
					}
					if(loc.getRelative(BlockFace.EAST).getRelative(BlockFace.SOUTH).getType() == Material.AIR){
						loc.getRelative(BlockFace.EAST).getRelative(BlockFace.SOUTH).setType(Material.WEB);
					}

					new BukkitRunnable(){	
						public void run(){

							DelaySnowball.remove(player.getName());
							player.sendMessage(ChatColor.GREEN + "Sua Habilidade foi carregada");
						}
					}.runTaskLater(plugin, 20 * 10);
				}else{
					player.sendMessage(ChatColor.RED + "Você deve esperar para usar esse poder");
				}
			}
		}
	}

	@EventHandler
	public void SpiderMan(PlayerMoveEvent e){
		Player player = e.getPlayer();
		if(BGKit.hasAbility(player,  Integer.valueOf(1001)).booleanValue()){
			BlockFace bf = yawToFace(player.getLocation().getYaw());
			Block block = player.getLocation().getBlock().getRelative(bf);
			if (block.getType() != Material.AIR) {
				for (int i = 0; i < 300; i++) {
					Block temp = block.getLocation().add(0.0D, i, 0.0D).getBlock();
					Block opp = player.getLocation().add(0.0D, i, 0.0D).getBlock();
					Block aboveOpp = opp.getLocation().add(0.0D, 1.0D, 0.0D).getBlock();
					int counter = 0;
					for (int k = 0; k < noVineBlocks.size(); k++) {
						if ((temp.getType() != Material.AIR) && (temp.getTypeId() != ((Integer)noVineBlocks.get(k)).intValue()))
							counter++;
					}
					if ((counter != noVineBlocks.size()) || ((opp.getType() != Material.AIR) && (opp.getType() != Material.LONG_GRASS) && (opp.getType() != Material.YELLOW_FLOWER) && (opp.getType() != Material.RED_ROSE))) break;
					if (aboveOpp.getType() == Material.AIR) {
						player.sendBlockChange(opp.getLocation(), Material.VINE, (byte)0);
					}
					player.setFallDistance(0.0F);
				}
			}
		}
	}

	public BlockFace yawToFace(float yaw) {
		BlockFace[] axis = { BlockFace.SOUTH, BlockFace.WEST, BlockFace.NORTH, BlockFace.EAST };
		return axis[(java.lang.Math.round(yaw / 90.0F) & 0x3)];
	}
	//-------------------------------------------------------------------------------

	//Viking -- iBieel
	@EventHandler
	public void VikingPowerful(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Player){
			Player player = (Player) e.getDamager();
			if(BGKit.hasAbility(player,  Integer.valueOf(1002)).booleanValue()){
				if(player.getItemInHand().getType() == Material.WOOD_AXE || player.getItemInHand().getType() == Material.STONE_AXE || player.getItemInHand().getType() == Material.IRON_AXE || player.getItemInHand().getType() == Material.GOLD_AXE || player.getItemInHand().getType() == Material.DIAMOND_AXE){
					int dano = e.getDamage();
					e.setDamage(dano + 2);
				}
			}
		}
	}

	@EventHandler
	public void VikingBigHit(PlayerInteractEvent e){
		Player player = (Player) e.getPlayer();
		if(BGKit.hasAbility(player,  Integer.valueOf(1003)).booleanValue()){
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
				if(player.getItemInHand().getType() == Material.GOLD_AXE){
					if(e.getItem().getDurability() < 32){
						short dur = (short) (e.getItem().getDurability() + 8);
						e.getItem().setDurability(dur);
						List<Entity> players = player.getNearbyEntities(5, 5, 5);
						for(Entity a : players){
							if(a != player){
								a.setFireTicks(20*5);	
							}
						}
					} else{
						player.sendMessage(ChatColor.RED + "Este machado está com a durabilidade insuficiente para usar a habilidade.");
					}
				}
			}
		}
	}

	//-------------------------------------------------------------------------------

	//Poseidom -- iBieel/Smooph
	List<String> ActivePoseidon = new ArrayList<String>();
	List<String> Delay = new ArrayList<String>();
	@EventHandler
	public void PoseidomRespirarAgua(PlayerInteractEvent e){
		final Player player = e.getPlayer();
		if(BGKit.hasAbility(player,  Integer.valueOf(1004)).booleanValue()){
			Material material = player.getLocation().getBlock().getType();
			if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR){
				if(material == Material.WATER || material == Material.STATIONARY_WATER){
					if(player.getItemInHand().getType() == Material.SUGAR_CANE){
						if(!(Delay.contains(player.getName()))){
							player.getInventory().removeItem(new ItemStack(Material.SUGAR_CANE, 1));
							ActivePoseidon.add(e.getPlayer().getName());
							player.sendMessage(ChatColor.DARK_AQUA + "Modo Posseidom Ativado");
							Delay.add(player.getName());
							new BukkitRunnable(){
								public void run(){
									ActivePoseidon.remove(player.getName());
									cancel();
									player.sendMessage(ChatColor.DARK_AQUA + "Modo Posseidom Desativado");
								}
							}.runTaskLater(plugin, 20*10);
							new BukkitRunnable(){
								public void run(){
									Delay.remove(player.getName());
									cancel();
									player.sendMessage(ChatColor.GREEN + "Habilidade Poseidom carregada");
								}
							}.runTaskTimer(plugin, 20*50, 0);
						} else{
							player.sendMessage(ChatColor.RED + "Você deve esperar para usar essa Habilidade");
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void PoseidomDanoAgua(EntityDamageEvent e){  
		if(e.getEntity() instanceof Player){
			Player player = (Player) e.getEntity();
			if(BGKit.hasAbility(player,  Integer.valueOf(1004)).booleanValue()){
				if(e.getCause() == DamageCause.DROWNING){
					if(ActivePoseidon.contains(player.getName())){
						e.setCancelled(true);
					}
				}
			}
		}
	}

	@EventHandler
	public void PoseidomPowerful(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Player){
			Player player = (Player) e.getDamager();
			if(BGKit.hasAbility(player,  Integer.valueOf(1005)).booleanValue()){
				Material material = player.getLocation().getBlock().getType();
				if(material == Material.WATER || material == Material.STATIONARY_WATER){
					int dano = e.getDamage();  
					e.setDamage(dano + 2);
				}
			}
		}
	}
	//-------------------------------------------------------------------------------

	//Voador -- iBieel 
	List<String> DelayVoador = new ArrayList<String>();
	@EventHandler
	public void VoadorUsar(PlayerInteractEvent e){
		final Player player = (Player) e.getPlayer();
		if(BGKit.hasAbility(player, Integer.valueOf(1006)).booleanValue()){

			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
				if(player.getItemInHand().getTypeId() == 288){
					if(!(DelayVoador.contains(player.getName()))){
						player.sendMessage(ChatColor.YELLOW + "Você pode voar por 5 segundos, aproveite.");
						DelayVoador.add(player.getName());
						player.setAllowFlight(true);
						new BukkitRunnable(){
							@Override
							public void run() {
								player.setAllowFlight(false);
							}	
						}.runTaskLater(plugin, 20 * 5);

						new BukkitRunnable(){
							public void run(){
								DelayVoador.remove(player.getName());
							}
						}.runTaskLater(plugin, 20 * 55);
					} else{
						player.sendMessage(ChatColor.RED + "Você deve esperar para usar essa habilidade");
					}
				}
			}
		}
	}

	//-------------------------------------------------------------------------------

	//EnderMage iBieel 
	List<String> DelayEnderMage = new ArrayList<>();

	@EventHandler
	public void EnderMage(BlockPlaceEvent e){
		if(e.getBlockPlaced().getTypeId() == 90){
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void EnderMage(PlayerInteractEvent e){
		final Player player = (Player) e.getPlayer();
		if(BGKit.hasAbility(player, Integer.valueOf(1007)).booleanValue()){
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
				if(player.getItemInHand().getTypeId() == 90){
					if(!(DelayEnderMage.contains(player.getName()))){
						for(Entity a : player.getNearbyEntities(5,100,5)){
							if(a instanceof Player){
								if(a != player){
									Location location = player.getLocation();
									a.teleport(location);

								}
								DelayEnderMage.add(player.getName());
								new BukkitRunnable(){
									public void run(){
										DelayEnderMage.remove(player.getName());
									}
								}.runTaskLater(plugin, 20 * 60);
							}
						}
					}else{
						player.sendMessage(ChatColor.RED + "Você deve esperar para usar essa habilidade novamente");
					}
				}
			}
		}
	}
	//-------------------------------------------------------------------------------

	//Jumper -- Smooph
	List<String> DelayJumper = new ArrayList<>();

	@EventHandler
	public void Jumper(PlayerInteractEvent e){
		final Player player = (Player) e.getPlayer();
		if(BGKit.hasAbility(player,  Integer.valueOf(1008)).booleanValue()){
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
				if(player.getItemInHand().getTypeId() == 348){
					if(!(DelayJumper.contains(player.getName()))){
						for(Entity a : player.getNearbyEntities(5,100,5)){
							if(a instanceof Player){
								if(a != player){
									Location location = new Location(null, 0, 0, 0);
									location.setWorld(player.getWorld());
									for (int i = 1; i <= 10; i++) {
										location.setX(a.getLocation().getX());
										location.setY(a.getLocation().getY()+1);
										location.setZ(a.getLocation().getZ());
										a.teleport(location);
									}

								}
								DelayJumper.add(player.getName());
								new BukkitRunnable(){
									public void run(){
										DelayJumper.remove(player.getName());
									}
								}.runTaskLater(plugin, 20 * 60);
							}
						}
					}else{
						player.sendMessage(ChatColor.RED + "Você deve esperar para usar essa habilidade novamente");
					}
				}
			}
		}
	}


}







