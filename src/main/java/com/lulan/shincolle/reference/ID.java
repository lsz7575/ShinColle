package com.lulan.shincolle.reference;

//for array ID
public class ID {

	/**GUI Button ID*/
	public static final class B {
		public static final byte ShipInv_Melee = 0;
		public static final byte ShipInv_AmmoLight = 1;
		public static final byte ShipInv_AmmoHeavy = 2;
		public static final byte ShipInv_AirLight = 3;
		public static final byte ShipInv_AirHeavy = 4;
		public static final byte ShipInv_FollowMin = 5;
		public static final byte ShipInv_FollowMax = 6;
		public static final byte ShipInv_FleeHP = 7;
		public static final byte ShipInv_TarAI = 8;
		public static final byte ShipInv_AuraEffect = 9;
		public static final byte ShipInv_OnSightAI = 10;
		public static final byte ShipInv_PVPAI = 11;
		public static final byte ShipInv_AAAI = 12;
		public static final byte ShipInv_ASMAI = 13;
		
		public static final byte Shipyard_Type = 0;
		public static final byte Shipyard_InvMode = 1;
		public static final byte Shipyard_SelectMat = 2;
		public static final byte Shipyard_INCDEC = 3;
		
		public static final byte Desk_Sync = 0;
	}
	
	/**shipyard build type*/
	public static final class Build {
		public static final byte NONE = 0;
		public static final byte SHIP = 1;
		public static final byte EQUIP = 2;
		public static final byte SHIP_LOOP = 3;
		public static final byte EQUIP_LOOP = 4;
	}
	
	/**Equip Map*/
	public static final class E {
		public static final byte LEVEL = 0;
		public static final byte HP = 1;
		public static final byte ATK_L = 2;
		public static final byte ATK_H = 3;
		public static final byte ATK_AL = 4;
		public static final byte ATK_AH = 5;
		public static final byte DEF = 6;
		public static final byte SPD = 7;
		public static final byte MOV = 8;
		public static final byte HIT = 9;
		public static final byte CRI = 10;
		public static final byte DHIT = 11;
		public static final byte THIT = 12;
		public static final byte MISS = 13;
		public static final byte AA = 14;
		public static final byte ASM = 15;
		public static final byte RARE_TYPE = 16;
		public static final byte RARE_MEAN = 17;
		public static final byte DODGE = 18;
	}
	
	/**Emotion*/
	public static final class Emotion {
		public static final byte NORMAL = 0;			//no emotion
		public static final byte BLINK = 1;				//blink eye
		public static final byte T_T = 2;				//sad
		public static final byte O_O = 3;				//...
		public static final byte BORED = 4;				//sit phase 2
		public static final byte HUNGRY = 5;			//no grudge
	}
	
	/**Equip type*/
	public static final class EquipType {
		public static final byte CANNON_SI = 0;			//single cannon
		public static final byte CANNON_TW_LO = 1;		//low level twin cannon
		public static final byte CANNON_TW_HI = 2;		//high level twin cannon
		public static final byte CANNON_TR = 3;			//triple cannon
		public static final byte TORPEDO_LO = 4;		//low level torpedo
		public static final byte TORPEDO_HI = 5;		//high level torpedo
		public static final byte AIR_T_LO = 6;			//low level aircraft T
		public static final byte AIR_T_HI = 7;			//high level aircraft T
		public static final byte AIR_F_LO = 8;			//low level aircraft F
		public static final byte AIR_F_HI = 9;			//high level aircraft F
		public static final byte AIR_B_LO = 10;			//low level aircraft B
		public static final byte AIR_B_HI = 11;			//high level aircraft B
		public static final byte AIR_R_LO = 12;			//low level aircraft R
		public static final byte AIR_R_HI = 13;			//high level aircraft R
		public static final byte RADAR_LO = 14;			//low level radar
		public static final byte RADAR_HI = 15;			//high level radar
		public static final byte TURBINE_LO = 16;		//low level turbine
		public static final byte TURBINE_HI = 17;		//high level turbine
		public static final byte ARMOR_LO = 18;			//low level armor
		public static final byte ARMOR_HI = 19;			//high level armor
		public static final byte GUN_LO = 20;			//low level machine gun
		public static final byte GUN_HI = 21;			//high level machine gun
		public static final byte CATAPULT_LO = 22;		//low level catapult
		public static final byte CATAPULT_HI = 23;		//high level catapult
	}
	
	/** Entity Flag */
	public static final class F {
		public static final byte CanFloatUp = 0;
		public static final byte IsMarried = 1;
		public static final byte NoFuel = 2;
		public static final byte UseMelee = 3;
		public static final byte UseAmmoLight = 4;
		public static final byte UseAmmoHeavy = 5;
		public static final byte UseAirLight = 6;
		public static final byte UseAirHeavy = 7;
		public static final byte HeadTilt = 8;			//client only, no sync
		public static final byte UseRingEffect = 9;
		public static final byte CanDrop = 10;			//server only, no sync
		public static final byte CanFollow = 11;
		public static final byte OnSightChase = 12;
		public static final byte AtkType_Light = 13;
		public static final byte AtkType_Heavy = 14;
		public static final byte AtkType_AirLight = 15;
		public static final byte AtkType_AirHeavy = 16;
		public static final byte HaveRingEffect = 17;
		public static final byte PVPFirst = 18;
		public static final byte AntiAir = 19;
		public static final byte AntiSS = 20;
		public static final byte PassiveAI = 21;
	}
	
	/** Update Flag */
	public static final class FU {
		public static final byte FormationBuff = 0;
	}
	
	/** Formation Effect */
	public static final class Formation {
		public static final byte ATK_L = 0;
		public static final byte ATK_H = 1;
		public static final byte ATK_AL = 2;
		public static final byte ATK_AH = 3;
		public static final byte DEF = 4;
		public static final byte MOV = 5;
		public static final byte MISS = 6;
		public static final byte DODGE = 7;
		public static final byte CRI = 8;
		public static final byte DHIT = 9;
		public static final byte THIT = 10;
		public static final byte AA = 11;
		public static final byte ASM = 12;
	}
	
	/** Formation Fixed Effect */
	public static final class FormationFixed {
		public static final byte MOV = 0;
	}
	
	/**GUI ID*/
	public static final class G {
		public static final byte SHIPINVENTORY = 0;
		public static final byte SMALLSHIPYARD = 1;
		public static final byte LARGESHIPYARD = 2;
		public static final byte ADMIRALDESK = 3;
		public static final byte ADMIRALDESK_ITEM = 4;
		public static final byte FORMATION = 5;
	}
	
	/**ICON ID for BOOK*/
	public static final class Item {
		public static final byte IronIG = 0;
		public static final byte Grudge = 1;
		public static final byte GrudgeB = 2;
		public static final byte GrudgeBH = 3;
		public static final byte AbyssIG = 4;
		public static final byte AbyssB = 5;
		public static final byte PolymIG = 6;
		public static final byte PolymB = 7;
		public static final byte PolymBG = 8;
		public static final byte PolymOre = 9;
		public static final byte Gunpowder = 10;
		public static final byte Blazepowder = 11;
		public static final byte AmmoL = 12;
		public static final byte AmmoLC = 13;
		public static final byte AmmoH = 14;
		public static final byte AmmoHC = 15;
		public static final byte RpBucket = 16;
		public static final byte LaBucket = 17;
		public static final byte NStar = 18;
		public static final byte Ring = 19;
		public static final byte Paper = 20;
		public static final byte OwnPaper = 21;
		public static final byte Stick = 22;
		public static final byte KHammer = 23;
		public static final byte ModTool = 24;
		public static final byte SpawnEgg0 = 25;
		public static final byte SpawnEgg1 = 26;
		public static final byte SpawnEgg2 = 27;
		public static final byte InstantMat = 28;
		public static final byte DiamondB = 29;
		public static final byte RpGod = 30;
		public static final byte Pointer = 31;
		public static final byte ModelZF = 32;
		public static final byte Desk = 33;
		public static final byte ObsidianB = 34;
		public static final byte WoolB = 35;
		public static final byte SmallSY = 36;
		public static final byte EqCannon0 = 37;
		public static final byte EqCannon1 = 38;
		public static final byte EqCannon2 = 39;
		public static final byte EqMGun = 40;
		public static final byte EqCatap = 41;
		public static final byte EqRadar = 42;
		public static final byte EqTurbine = 43;
		public static final byte EqTorpedo = 44;
		public static final byte EqAirT = 45;
		public static final byte EqAirF = 46;
		public static final byte EqAirB = 47;
		public static final byte EqAirR = 48;
		public static final byte EqArmor = 49;
		public static final byte DeskBook = 50;
		public static final byte DeskRadar = 51;
		public static final byte WriteBook = 52;
		public static final byte Compass = 53;
	}
	
	/**ship state2*/
	public static final class HPState {
		public static final byte NORMAL = 0;	//無受損
		public static final byte MINOR = 1;		//小破
		public static final byte MODERATE = 2;	//中破
		public static final byte HEAVY = 3;		//大破
	}
	
	/** item type for part of item */
	public static final class ItemType {
		public static final byte AbyssMetal = 1;
		public static final byte AbyssMetal_Abyssium = 2;
		public static final byte AbyssMetal_Polymetal = 3;
		public static final byte Ammo = 4;
		public static final byte Ammo_L = 5;
		public static final byte Ammo_H = 6;
		public static final byte Ammo_LC = 7;
		public static final byte Ammo_HC = 8;
		public static final byte Grudge = 9;
		public static final byte BlockAbyssium = 10;
		public static final byte BlockGrudge = 11;
		public static final byte BlockPolymetal = 12;
		public static final byte BlockPolymetalGravel = 13;
		public static final byte EquipAirplane = 14;
		public static final byte EquipArmor = 15;
		public static final byte EquipCannon = 16;
		public static final byte EquipCatapult = 17;
		public static final byte EquipMachinegun = 18;
		public static final byte EquipRadar = 19;
		public static final byte EquipTorpedo = 20;
		public static final byte EquipTurbine = 21;
	}
	
	/** Minor State */
	public static final class M {
		public static final byte ShipLevel = 0;
		public static final byte Kills = 1;
		public static final byte ExpCurrent = 2;	//exp curr/next
		public static final byte ExpNext = 3;
		public static final byte NumAmmoLight = 4;
		public static final byte NumAmmoHeavy = 5;
		public static final byte NumGrudge = 6;
		public static final byte NumAirLight = 7;
		public static final byte NumAirHeavy = 8;
		public static final byte ImmuneTime = 9;	//entity immune time
		public static final byte FollowMin = 10;	//follow range min/max
		public static final byte FollowMax = 11;	
		public static final byte FleeHP = 12;		//flee hp%
		public static final byte TargetAI = 13;		//NO USE
		public static final byte GuardX = 14;		//guard xyz pos
		public static final byte GuardY = 15;
		public static final byte GuardZ = 16;
		public static final byte GuardDim = 17;		//guard entity world id
		public static final byte GuardID = 18;		//guard entity id
		public static final byte ShipType = 19;		//ship type
		public static final byte ShipClass = 20;	//ship class
		public static final byte PlayerUID = 21;	//player UID
		public static final byte ShipUID = 22;		//ship UID
		public static final byte PlayerEID = 23;	//player entity id
		public static final byte GuardType = 24;	//guard type: 0:move 1:move & attack
		public static final byte DamageType = 25;	//damage type
		public static final byte FormatType = 26;	//formation type
		public static final byte FormatPos = 27;	//formation position
	}
	
	/** ring effect, no used for now */
	public static final class R {
		public static final byte Haste = 0;
		public static final byte Speed = 1;
		public static final byte Jump = 2;
		public static final byte Damage = 3;
	}
	
	/** Entity State */
	public static final class S {
		public static final byte State = 0;				//equip state
		public static final byte Emotion = 1;			//emotion
		public static final byte Emotion2 = 2;			//emotion 2
		public static final byte HPState = 3;			//hp state
		public static final byte State2 = 4;			//equip state 2
		public static final byte Phase = 5;				//entity phase
	}
	
	/** ship id */
	public static final class Ship {
		public static final short DestroyerI = 0;
		public static final short DestroyerRO = 1;
		public static final short DestroyerHA = 2;
		public static final short DestroyerNI = 3;
		
		public static final short LightCruiserHO = 4;
		public static final short LightCruiserHE = 5;
		public static final short LightCruiserTO = 6;
		public static final short LightCruiserTSU = 7;
		
		public static final short TorpedoCruiserCHI = 8;
		public static final short HeavyCruiserRI = 9;
		public static final short HeavyCruiserNE = 10;
		
		public static final short LightCarrierNU = 11;
		public static final short CarrierWO = 12;
		
		public static final short BattleshipRU = 13;
		public static final short BattleshipTA = 14;
		public static final short BattleshipRE = 15;
		
		public static final short TransportWA = 16;
		public static final short SubmarineKA = 17;
		public static final short SubmarineYO = 18;
		public static final short SubmarineSO = 19;
		
		public static final short CarrierHime = 20;
		public static final short AirfieldHime = 21;
		public static final short ArmoredCarrierHime = 22;
		public static final short AnchorageHime = 23;
		public static final short HarbourWD = 24;
		public static final short AnchorageWD = 25;
		public static final short BattleshipHime = 26;
		public static final short DestroyerHime = 27;
		public static final short HarbourHime = 28;
		public static final short IsolatedDemon = 29;
		public static final short MidwayHime = 30;
		public static final short NorthernHime = 31;
		public static final short SouthernHime = 32;
		public static final short CarrierWD = 33;
		public static final short LightCruiserDemon = 34;
		public static final short BattleshipWD = 35;
		
		public static final short DestroyerShimakaze = 36;
		public static final short BattleshipNagato = 37;
		public static final short SubmarineU511 = 38;
		public static final short SubmarineRo500 = 39;
		
		public static final short SeaplaneHime = 40;
		public static final short AirdefenseHime = 41;
		public static final short PTImp = 42;
		public static final short LightCruiserHime = 43;
		public static final short SubmarineHime = 44;
		public static final short DestroyerWD = 45;
		
		public static final short BattleshipYamato = 46;
	}
	
	/** ship attrs id, for Values.ShipAttrMap */
	public static final class ShipAttr {
		public static final byte BaseHP = 0;
		public static final byte BaseATK = 1;
		public static final byte BaseDEF = 2;
		public static final byte BaseSPD = 3;
		public static final byte BaseMOV = 4;
		public static final byte BaseHIT = 5;
		public static final byte ModHP = 6;
		public static final byte ModATK = 7;
		public static final byte ModDEF = 8;
		public static final byte ModSPD = 9;
		public static final byte ModMOV = 10;
		public static final byte ModHIT = 11;
	}
	
	/**ship damage type*/
	public static final class ShipDmgType {
		public static final byte UNDEFINED = 0;			//其他, 未定義
		public static final byte CARRIER = 1;			//空母
		public static final byte AVIATION = 2;			//航戰
		public static final byte BATTLESHIP	= 3;		//戰艦
		public static final byte CRUISER = 4;			//巡洋
		public static final byte DESTROYER = 5;			//驅逐
		public static final byte SUBMARINE = 6;			//潛艇
		public static final byte AIRPLANE = 7;			//飛行物
	}
	
	/**ship type*/
	public static final class ShipType {				//for GUI display
		public static final byte DESTROYER = 0;			//驅逐艦
		public static final byte LIGHT_CRUISER = 1;		//輕巡洋艦
		public static final byte HEAVY_CRUISER = 2;		//重巡洋艦
		public static final byte TORPEDO_CRUISER = 3;	//重雷裝巡洋艦
		public static final byte LIGHT_CARRIER = 4;		//輕航空母艦
		public static final byte STANDARD_CARRIER = 5;	//正規航空母艦
		public static final byte BATTLESHIP	= 6;		//戰艦
		public static final byte TRANSPORT = 7;			//運輸艦
		public static final byte SUBMARINE = 8;			//潛水艇
		public static final byte DEMON = 9;				//鬼級, 水鬼級
		public static final byte HIME = 10;				//姬級
	}
	
	/**ship state*/
	public static final class State {
		/**for ID.S.State*/
		public static final byte NORMAL = 0;		//無狀態
		public static final byte EQUIP00 = 20;		//艤裝狀態0
		public static final byte EQUIP01 = 30;		//艤裝狀態1
		public static final byte EQUIP02 = 40;		//艤裝狀態2
		public static final byte EQUIP03 = 50;		//艤裝狀態3
		public static final byte EQUIP04 = 60;		//艤裝狀態4
		public static final byte EQUIP05 = 70;		//艤裝狀態5
		/**for ID.S.State2*/
		public static final byte NORMAL_2 = 0;		//無狀態
		public static final byte EQUIP00_2 = 1;		//艤裝狀態0
		public static final byte EQUIP01_2 = 2;		//艤裝狀態1
		public static final byte EQUIP02_2 = 3;		//艤裝狀態2
		public static final byte EQUIP03_2 = 4;		//艤裝狀態3
		public static final byte EQUIP04_2 = 5;		//艤裝狀態4
		public static final byte EQUIP05_2 = 6;		//艤裝狀態5
	}

	/**StateEquip, StateFinal, BonusPoint, TypeModify*/
	public static final byte HP = 0;
	public static final byte ATK = 1;
	public static final byte DEF = 2;
	public static final byte SPD = 3;
	public static final byte MOV = 4;
	public static final byte HIT = 5;
	public static final byte ATK_H = 6;
	public static final byte ATK_AL = 7;
	public static final byte ATK_AH = 8;
	
	/**Effect Equip*/
	public static final byte EF_CRI = 0;
	public static final byte EF_DHIT = 1;
	public static final byte EF_THIT = 2;
	public static final byte EF_MISS = 3;
	public static final byte EF_AA = 4;
	public static final byte EF_ASM = 5;
	public static final byte EF_DODGE = 6;
	
	/**Equip ID*/
	//cannon
	public static final byte E_CANNON_SINGLE_5 = 0;
	public static final byte E_CANNON_SINGLE_6 = 1;
	public static final byte E_CANNON_TWIN_5 = 2;
	public static final byte E_CANNON_TWIN_6 = 3;
	public static final byte E_CANNON_TWIN_5DP = 4;
	public static final byte E_CANNON_TWIN_125 = 5;
	public static final byte E_CANNON_TWIN_14 = 6;
	public static final byte E_CANNON_TWIN_16 = 7;
	public static final byte E_CANNON_TWIN_20 = 8;
	public static final byte E_CANNON_TRI_8 = 9;
	public static final byte E_CANNON_TRI_16 = 10;
	public static final byte E_CANNON_FG_15 = 11;
	//torpedo
	public static final byte E_TORPEDO_21MK1 = 20;
	public static final byte E_TORPEDO_21MK2 = 21;
	public static final byte E_TORPEDO_22MK1 = 22;
	public static final byte E_TORPEDO_CUTTLEFISH = 23;
	public static final byte E_TORPEDO_HIGHSPEED = 24;
	//aircraft
	public static final byte E_AIRCRAFT_TMK1 = 30;
	public static final byte E_AIRCRAFT_TMK2 = 31;
	public static final byte E_AIRCRAFT_TMK3 = 32;
	public static final byte E_AIRCRAFT_TAVENGER = 33;
	public static final byte E_AIRCRAFT_FMK1 = 34;
	public static final byte E_AIRCRAFT_FMK2 = 35;
	public static final byte E_AIRCRAFT_FMK3 = 36;
	public static final byte E_AIRCRAFT_FFLYFISH = 37;
	public static final byte E_AIRCRAFT_FHELLCAT = 38;
	public static final byte E_AIRCRAFT_BMK1 = 39;
	public static final byte E_AIRCRAFT_BMK2 = 40;
	public static final byte E_AIRCRAFT_BFLYFISH = 41;
	public static final byte E_AIRCRAFT_BHELL = 42;
	public static final byte E_AIRCRAFT_R = 43;
	public static final byte E_AIRCRAFT_RFLYFISH = 44;
	public static final byte E_AIRCRAFT_TAVENGERK = 45;
	public static final byte E_AIRCRAFT_FHELLCATK = 46;
	public static final byte E_AIRCRAFT_BHELLK = 47;
	//radar
	public static final byte E_RADAR_AIRMK1 = 50;
	public static final byte E_RADAR_AIRMK2 = 51;
	public static final byte E_RADAR_SURMK1 = 52;
	public static final byte E_RADAR_SURMK2 = 53;
	public static final byte E_RADAR_SONAR = 54;
	public static final byte E_RADAR_AIRABYSS = 55;
	public static final byte E_RADAR_SURABYSS = 56;
	public static final byte E_RADAR_SONARMK2 = 57;
	public static final byte E_RADAR_FCSCIC = 58;
	//turbine
	public static final byte E_TURBINE = 60;
	public static final byte E_TURBINE_IMP = 61;
	public static final byte E_TURBINE_ENH = 62;
	//armor
	public static final byte E_ARMOR = 70;
	public static final byte E_ARMOR_ENH = 71;
	//machine gun
	public static final byte E_GUN_HA_3 = 80;
	public static final byte E_GUN_HA_5 = 81;
	public static final byte E_GUN_SINGLE_12 = 82;
	public static final byte E_GUN_SINGLE_20 = 83;
	public static final byte E_GUN_TWIN_40 = 84;
	public static final byte E_GUN_QUAD_40 = 85;
	public static final byte E_GUN_TWIN_4_CIC = 86;
	//catapult
	public static final byte E_CATAPULT_F = 100;
	public static final byte E_CATAPULT_H = 101;
	public static final byte E_CATAPULT_C = 102;
	public static final byte E_CATAPULT_E = 103;
	
		
}
