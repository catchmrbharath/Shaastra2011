package com.shaastra;

import java.util.HashMap;
public final class gallerymanager {
	
	public static final Integer[] catIds={R.drawable.impact,R.drawable.design,R.drawable.coding,R.drawable.involve,R.drawable.dept,R.drawable.spotlight,R.drawable.exhi,R.drawable.quiz,R.drawable.gradient,R.drawable.exhi,R.drawable.involve};
	public static final Integer[] imageIDs = {
		R.drawable.wright, R.drawable.biomodelling, R.drawable.chemtrek, R.drawable.infrafest, R.drawable.codemorphing,R.drawable.desmod,R.drawable.scdc,
		 R.drawable.robotics,R.drawable.robowars,R.drawable.contraption,R.drawable.junkyardwars,R.drawable.projectx,R.drawable.firenice,R.drawable.pentathlon,
		 R.drawable.chemx,R.drawable.dailyevents,R.drawable.writing,R.drawable.involve,R.drawable.puzzlechamp,R.drawable.cubeopen,R.drawable.wattsup,R.drawable.iq,R.drawable.mathmodelling,
 //aerofest
		 R.drawable.aerobotics,R.drawable.topgun,R.drawable.airshow,R.drawable.paperplane,
		 R.drawable.gamersinn,R.drawable.maze,R.drawable.bullsandbears,R.drawable.paper,R.drawable.lecturesandvcs,R.drawable.idp,
		 R.drawable.smq,R.drawable.htw,R.drawable.autoquiz,

 R.drawable.automania,R.drawable.babel,R.drawable.opc,R.drawable.distro,R.drawable.simchamp,R.drawable.hackfest,R.drawable.datamining,R.drawable.codeobfuscation,
 R.drawable.ethicalhacking,R.drawable.innovationeer,R.drawable.astronomyworkshop,R.drawable.nanomaterial,R.drawable.forensics,R.drawable.fossils,R.drawable.android,R.drawable.digitalcircuits,
//online
 R.drawable.estockbazaar,R.drawable.onlinemath,R.drawable.onlinepuzzlechamp,R.drawable.onlinequiz,R.drawable.onlinekryptx,R.drawable.onlinekryptx,R.drawable.android,

 R.drawable.industrial,R.drawable.gov,R.drawable.industrial,R.drawable.exhi,R.drawable.shaastranights,
R.drawable.symposium,R.drawable.impact,R.drawable.impact,R.drawable.impact,
R.drawable.writing,
//workshops
R.drawable.gradient
        };
	public static final Integer[][] eventids  = {
        {65,66,67,68},
        {8,9,10,11,12,13,14},
        {37,38,39,40,41,42,43,44},
        {15,16,17,18,19,20,21,22,23},
        {1,2,3,4,5,6,7},	
        {28,29,30,31,32,33},
        {60,61,62,63,64},
        {34,35,36},
        {53,54,55,56,57,58,69},
        {45,46,47,48,49,50,51,52,70},
        {24,25,26,27}
       };

	public static final HashMap<Integer, String> eventNameHash = new HashMap<Integer, String>();
	static {
	eventNameHash.put(1," Wright Design "); 
	eventNameHash.put(2," BioDocks! "); 
	eventNameHash.put(3," Chemtrek "); 
	eventNameHash.put(4," Infrafest "); 
	eventNameHash.put(5," Code Darwin "); 
	eventNameHash.put(6," Desmod "); 
	eventNameHash.put(7," SCDC "); 
	eventNameHash.put(8," Robotics "); 
	eventNameHash.put(9," RoboWars "); 
	eventNameHash.put(10," Contraptions "); 
	eventNameHash.put(11," Junkyard Wars "); 
	eventNameHash.put(12," Project X "); 
	eventNameHash.put(13," Fire N Ice "); 
	eventNameHash.put(14," Pentathlon "); 
	eventNameHash.put(15," Chemical X "); 
	eventNameHash.put(16," Daily Events "); 
	eventNameHash.put(17," Sci-fi Writing "); 
	eventNameHash.put(18," Ignobel "); 
	eventNameHash.put(19," Puzzle Championship "); 
	eventNameHash.put(20," Shaastra Cube Open "); 
	eventNameHash.put(21," Watts Up "); 
	eventNameHash.put(22," IQ "); 
	eventNameHash.put(23," Math Modelling "); 
	eventNameHash.put(24," Aerobotics "); 
	eventNameHash.put(25," Top Gun "); 
	eventNameHash.put(26," Air Show "); 
	eventNameHash.put(27," Paper Plane "); 
	eventNameHash.put(28," Gamer's Inn "); 
	eventNameHash.put(29," Shaastra Maze-Takeshi's Castle "); 
	eventNameHash.put(30," Bulls & Bears "); 
	eventNameHash.put(31," Paper & Poster Presentation "); 
	eventNameHash.put(32," Lectures & VCs "); 
	eventNameHash.put(33," Industry Defined Problems "); 
	eventNameHash.put(34," Shaastra Main Quiz "); 
	eventNameHash.put(35," How Things Work "); 
	eventNameHash.put(36," Auto Quiz "); 
	eventNameHash.put(37," Automania "); 
	eventNameHash.put(38," Babel "); 
	eventNameHash.put(39," Online Programming Contest "); 
	eventNameHash.put(40," Distro "); 
	eventNameHash.put(41," Sim Champ "); 
	eventNameHash.put(42," HACKFEST "); 
	eventNameHash.put(43," Deep Blue "); 
	eventNameHash.put(44," Code Obfuscation "); 
	eventNameHash.put(45," Ethical Hacking Workshop "); 
	eventNameHash.put(46," Innovationeer "); 
	eventNameHash.put(47," Astrophotography "); 
	eventNameHash.put(48," Nanomaterials "); 
	eventNameHash.put(49," Forensics "); 
	eventNameHash.put(50," Fossils "); 
	eventNameHash.put(51," Android Development "); 
	eventNameHash.put(52," Digital Circuits "); 
	eventNameHash.put(53," Estock Bazaar "); 
	eventNameHash.put(54," Online Math Champ "); 
	eventNameHash.put(55," Online Puzzle Champ "); 
	eventNameHash.put(56," Online Quiz "); 
	eventNameHash.put(57," Kryptx "); 
	eventNameHash.put(58," Online Games "); 
	eventNameHash.put(59," testevent "); 
	eventNameHash.put(60," Industrial Expo "); 
	eventNameHash.put(61," Government Exhibition "); 
	eventNameHash.put(62," IIT Madras Technical Museum "); 
	eventNameHash.put(63," Innovation X "); 
	eventNameHash.put(64," Shaastra Nights "); 
	eventNameHash.put(65," IIT Madras Symposium 2011 "); 
	eventNameHash.put(66," Sankalp "); 
	eventNameHash.put(67," Inter-University Sustainability Challenge "); 
	eventNameHash.put(68," Shaastra Social Innovation Challenge "); 
	eventNameHash.put(69," Online Sci-Fi Writing "); 
	eventNameHash.put(70," Parallel Programming Workshop "); 
	}
	public static final HashMap<Integer, Integer> hackHash = new HashMap<Integer, Integer>();
	static{
		hackHash.put(1, 63);
		hackHash.put(2, 43);
		hackHash.put(3, 44);
		hackHash.put(4, 42);
		hackHash.put(5,41);
		hackHash.put(6,40);
		hackHash.put(7,39);
		hackHash.put(8,17);
		hackHash.put(9,13);
		hackHash.put(10,14);
		hackHash.put(11, 16);
		hackHash.put(12,18);
		hackHash.put(13,15);
		hackHash.put(14,19);
		hackHash.put(15,20);
		hackHash.put(16,21);
		hackHash.put(17,23);
		hackHash.put(18,24);
		hackHash.put(19,26);
		hackHash.put(20,27);
		hackHash.put(21,28);
		hackHash.put(22,22);
		hackHash.put(23,29);
		hackHash.put(24,1);
		hackHash.put(25,2);
		hackHash.put(26, 3);
		hackHash.put(27,4);
		hackHash.put(28, 62);
		hackHash.put(29, 64);
		hackHash.put(30, 60);
		hackHash.put(31, 65);
		hackHash.put(33, 66);
		hackHash.put(32, 67);
		hackHash.put(34,68);
		hackHash.put(35, 69);
		hackHash.put(36,70);
		hackHash.put(37, 5);
		hackHash.put(38, 6);
		hackHash.put(39, 7);
		hackHash.put(40, 8);
		hackHash.put(41, 9);
		hackHash.put(42, 10);
		hackHash.put(43, 11);
		hackHash.put(44, 12);
		hackHash.put(45,46);
		hackHash.put(46, 47);
		hackHash.put(47, 48);
		hackHash.put(48, 49);
		hackHash.put(49, 50);
		hackHash.put(50, 51);
		hackHash.put(51, 52);
		hackHash.put(52, 53);
		hackHash.put(53,71 );
		hackHash.put(54,72);
		hackHash.put(55, 73);
		hackHash.put(56,74);
		hackHash.put(57,75);
		hackHash.put(58, 76);
		hackHash.put(59, 23);
		hackHash.put(60, 77);
		hackHash.put(61,78);
		hackHash.put(62, 79);
		hackHash.put(63, 80);
		hackHash.put(64, 81);
		hackHash.put(65, 82);
		hackHash.put(66, 83);
		hackHash.put(67, 84);
		hackHash.put(68, 85);
		hackHash.put(69, 25);
		hackHash.put(70, 54);
	}


}