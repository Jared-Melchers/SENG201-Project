package seng201.team0.services;

import seng201.team0.models.Map;
import seng201.team0.models.Node;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

/**
 * A map for basic tests
 * @author jared
 */
public class Mapmaker {
    private Map map;

    /**
     * Returns the selected map
     * @param mapName the map to be used in the race
     * @return map
     */
    public Map getMap(String mapName) {
        switch (mapName) {
            case "map1":
                map = new Mapmaker().getMap1();
                break;
            case "map1R":
                map = new Mapmaker().getMap1R();
                break;
            case "map2":
                map = new Mapmaker().getMap2();
                break;
            case "map2R":
                map = new Mapmaker().getMap2R();
                break;
            case "map3":
                map = new Mapmaker().getMap3();
                break;
            case "map3R":
                map = new Mapmaker().getMap3R();
                break;
            case "map4":
                map = new Mapmaker().getMap4();
                break;
            case "map4R":
                map = new Mapmaker().getMap4R();
                break;
            case "map5":
                map = new Mapmaker().getMap5();
                break;
            case "map5R":
                map = new Mapmaker().getMap5R();
                break;
            case "map6":
                map = new Mapmaker().getMap6();
                break;
            case "map6R":
                map = new Mapmaker().getMap6R();
                break;
            case "map7":
                map = new Mapmaker().getMap7();
                break;
            case "map7R":
                map = new Mapmaker().getMap7R();
                break;
            case "map8":
                map = new Mapmaker().getMap8();
                break;
            case "map8R":
                map = new Mapmaker().getMap8R();
                break;
            case "FinalMap":
                map = new Mapmaker().getFinalMap();
                break;
        }

        return map;
    }

    /**
     * creates a List of the names of all the maps
     * @return ArrayList of Strings containing the names of the maps
     */
    public static ArrayList<String> getMaps(){
        ArrayList<String> maps = new ArrayList<>();
        maps.add("map1");
        maps.add("map1R");
        maps.add("map2");
        maps.add("map2R");
        maps.add("map3");
        maps.add("map3R");
        maps.add("map4");
        maps.add("map4R");
        maps.add("map5");
        maps.add("map5R");
        maps.add("map6");
        maps.add("map6R");
        maps.add("map7");
        maps.add("map7R");
        maps.add("map8");
        maps.add("map8R");
        maps.add("FinalMap");
        return maps;
    }

    /**
     * creates a list of the URL for the image of each map
     * @return ArrayList of Strings containing the URL for the images of each map
     */
    public static ArrayList<String> getMapImages(){
        ArrayList<String> mapImages = new ArrayList<>();
        mapImages.add("/images/Map1.JPG");
        mapImages.add("/images/Map1R.JPG");
        mapImages.add("/images/Map2.JPG");
        mapImages.add("/images/Map2R.JPG");
        mapImages.add("/images/Map3.JPG");
        mapImages.add("/images/Map3R.JPG");
        mapImages.add("/images/Map4.JPG");
        mapImages.add("/images/Map4R.JPG");
        mapImages.add("/images/Map5.JPG");
        mapImages.add("/images/Map5R.JPG");
        mapImages.add("/images/Map6.JPG");
        mapImages.add("/images/Map6R.JPG");
        mapImages.add("/images/Map7.JPG");
        mapImages.add("/images/Map7R.JPG");
        mapImages.add("/images/Map8.JPG");
        mapImages.add("/images/Map8R.JPG");
        mapImages.add("/images/Final Map.JPG");
        return mapImages;
    }

    /**
     * Creates the debug map
     * @return map An object containing the routes and nodes that make upt he map.
     */
    public Map getDebugMap() {

        // Initialises Nodes and routes, starting at the end and working backwards
        Node node9 = new Node(0, 4, new ArrayList<>(List.of()));
        Route route11 = new Route(100, new ArrayList<>(List.of("Mud", "Windy", "Steep")), node9);
        Route route12 = new Route(100, new ArrayList<>(List.of("Ice", "Windy", "Steep")), node9);

        Node node8 = new Node(1, 3, new ArrayList<>(List.of(route12)));
        Route route9 = new Route(100, new ArrayList<>(List.of("Gravel", "Windy", "Steep")), node8);
        Route route10 = new Route(100, new ArrayList<>(List.of("Mud", "Steep")), node8);

        Node node7 = new Node(-1, 3, new ArrayList<>(List.of(route11)));
        Route route7 = new Route(100, new ArrayList<>(List.of("Ice", "Steep")), node7);
        Route route8 = new Route(100, new ArrayList<>(List.of("Gravel", "Steep")), node7);

        Node node6 = new Node(2, 2, new ArrayList<>(List.of(route10)));
        Route route6 = new Route(100, new ArrayList<>(List.of("Mud", "Windy")), node6);

        Node node5 = new Node(0, 2, new ArrayList<>(List.of(route8, route9)));
        Route route4 = new Route(100, new ArrayList<>(List.of("Ice", "Windy")), node5);
        Route route5 = new Route(100, new ArrayList<>(List.of("Gravel", "Windy")), node5);

        Node node4 = new Node(-2, 2, new ArrayList<>(List.of(route7)));
        Route route3 = new Route(100, new ArrayList<>(List.of("Mud")), node4);

        Node node3 = new Node(1, 1, new ArrayList<>(List.of(route5, route6)));
        Route route2 = new Route(100, new ArrayList<>(List.of("Ice")), node3);

        Node node2 = new Node(-1, 1, new ArrayList<>(List.of(route3, route4)));
        Route route1 = new Route(100, new ArrayList<>(List.of("Gravel")), node2);

        Node node1 = new Node(0, 0, new ArrayList<>(List.of(route1, route2)));


        // Build and return the map
        map = new Map(new ArrayList<>(List.of(node1, node2, node3, node4, node5, node6, node7, node8, node9)), List.of(3000, 5000, 7000), 3000);
        return map;
    }

    /**
     * Returns the first map
     * @return map. An object containing the routes and nodes that make upt he map.
     */
    private Map getMap1() {
        Node node0 = new Node(345, 52, new ArrayList<>(List.of()));
        Route route1 = new Route( 100, new ArrayList<>(List.of()), node0);
        Route route2 = new Route(100, new ArrayList<>(List.of("Gravel")), node0);
        Route route3 = new Route(100, new ArrayList<>(List.of("Mud")), node0);

        Node node1 = new Node(259, 50, new ArrayList<>(List.of(route1)));
        Route route4 = new Route(100, new ArrayList<>(List.of()), node1);
        Route route5 = new Route(100, new ArrayList<>(List.of("Mud", "Windy")), node1);

        Node node2 = new Node(270, 119, new ArrayList<>(List.of(route2, route5)));
        Route route6 = new Route(100, new ArrayList<>(List.of("Gravel")), node2);
        Route route7 = new Route(100, new ArrayList<>(List.of("Gravel", "Windy")), node2);

        Node node3 = new Node(319, 214, new ArrayList<>(List.of(route3)));
        Route route8 = new Route(100, new ArrayList<>(List.of("Gravel")), node3);
        Route route9 = new Route(100, new ArrayList<>(List.of("Mud")), node3);

        Node node4 = new Node(139, 211, new ArrayList<>(List.of(route4, route6)));
        Route route10 = new Route(100, new ArrayList<>(List.of()), node4);

        Node node5 = new Node(234, 231, new ArrayList<>(List.of(route7, route8)));
        Route route11 = new Route(100, new ArrayList<>(List.of("Gravel")), node5);

        Node node6 = new Node(181, 307, new ArrayList<>(List.of(route10, route11)));
        Route route12 = new Route(100, new ArrayList<>(List.of()), node6);

        Node node7 = new Node(213, 371, new ArrayList<>(List.of(route12, route9)));

        // Build and return the map
        map = new Map(new ArrayList<>(List.of(node7, node2, node3, node4, node5, node6, node1)), List.of(300, 500, 700), 2000);
        return map;
    }

    /**
     * Returns a reversed version of the first map
     * @return map. An object containing the routes and nodes that make upt he map.
     */
    private Map getMap1R() {
        Node node0 = new Node(237, 28, new ArrayList<>(List.of()));
        Route route1 = new Route(100, new ArrayList<>(List.of("Mud")), node0);
        Route route2 = new Route(100, new ArrayList<>(List.of()), node0);

        Node node1 = new Node(268, 92, new ArrayList<>(List.of(route2)));
        Route route4 = new Route(100, new ArrayList<>(List.of("Gravel")), node1);
        Route route5 = new Route(100, new ArrayList<>(List.of()), node1);

        Node node2 = new Node(215, 168, new ArrayList<>(List.of(route4)));
        Route route6 = new Route(100, new ArrayList<>(List.of("Gravel")), node2);
        Route route7 =  new Route(100, new ArrayList<>(List.of("Gravel", "Windy")), node2);

        Node node3 = new Node(130, 185, new ArrayList<>(List.of(route1,route6)));
        Route route3 = new Route(100, new ArrayList<>(List.of("Mud")), node3);

        Node node4 = new Node(310, 188, new ArrayList<>(List.of(route5)));
        Route route8 = new Route(100, new ArrayList<>(List.of("Gravel")), node4);
        Route route9 = new Route(100, new ArrayList<>(List.of()), node4);

        Node node5 = new Node(179, 280, new ArrayList<>(List.of(route7,route8)));
        Route route10 = new Route(100, new ArrayList<>(List.of("Gravel")), node5);
        Route route11 = new Route(100, new ArrayList<>(List.of("Mud", "Windy")), node5);

        Node node6 = new Node(190, 350, new ArrayList<>(List.of(route11, route9)));
        Route route12 = new Route(100, new ArrayList<>(List.of()), node6);

        Node node7 = new Node(104, 347, new ArrayList<>(List.of(route12,route3,route10)));

        // Build and return the map
        map = new Map(new ArrayList<>(List.of(node7, node6, node5, node4, node3, node2, node1, node0)), List.of(300, 599, 700), 2000);
        return map;
    }

    private Map getMap2() {
        Node node0 = new Node(110, 342, new ArrayList<>(List.of()));
        Route route1 = new Route(100, new ArrayList<>(List.of("Gravel","Windy")), node0);
        Route route2 = new Route(100, new ArrayList<>(List.of()), node0);

        Node node1 = new Node(101, 281, new ArrayList<>(List.of(route1)));
        Route route3 = new Route(100, new ArrayList<>(List.of("Gravel","Windy")), node1);
        Route route4 = new Route(100, new ArrayList<>(List.of("Mud","Windy")), node1);

        Node node2 = new Node(164, 340,new ArrayList<>(List.of(route2)));
        Route route5 = new Route(100, new ArrayList<>(List.of("Gravel")), node2);
        Route route6 = new Route(100, new ArrayList<>(List.of()), node2);

        Node node3 = new Node(159, 272,new ArrayList<>(List.of(route4,route5)));
        Route route7 = new Route(100, new ArrayList<>(List.of("Mud","Windy")), node3);
        Route route8 = new Route(100, new ArrayList<>(List.of("Gravel","Windy")), node3);

        Node node4 = new Node(114, 219,new ArrayList<>(List.of(route3,route7)));
        Route route9 = new Route(100, new ArrayList<>(List.of("Gravel")), node4);

        Node node5 = new Node(208, 292,new ArrayList<>(List.of(route6)));
        Route route10 = new Route(100, new ArrayList<>(List.of("Mud")), node5);
        Route route11 = new Route(100, new ArrayList<>(List.of()), node5);

        Node node6 = new Node(197, 261,new ArrayList<>(List.of(route8,route10)));
        Route route12 = new Route(100, new ArrayList<>(List.of("Gravel")), node6);

        Node node7 = new Node(92, 183,new ArrayList<>(List.of(route9)));
        Route route13 = new Route(100, new ArrayList<>(List.of()), node7);

        Node node8 = new Node(231, 200,new ArrayList<>(List.of(route12)));
        Route route14 = new Route(100, new ArrayList<>(List.of("Mud")), node8);
        Route route15 = new Route(100, new ArrayList<>(List.of("Gravel")), node8);

        Node node9 = new Node(214, 141,new ArrayList<>(List.of(route14)));
        Route route16 = new Route(100, new ArrayList<>(List.of("Mud")), node9);
        Route route17 = new Route(100, new ArrayList<>(List.of("Gravel")), node9);

        Node node10 = new Node(142, 113,new ArrayList<>(List.of(route13,route16)));
        Route route18 = new Route(100, new ArrayList<>(List.of("Gravel","Windy")), node10);

        Node node11 = new Node(252, 205,new ArrayList<>(List.of(route15)));
        Route route19 = new Route(100, new ArrayList<>(List.of()), node11);

        Node node12 = new Node(309, 139,new ArrayList<>(List.of(route19)));
        Route route20 = new Route(100, new ArrayList<>(List.of("Mud")), node12);
        Route route21 = new Route(100, new ArrayList<>(List.of("Gravel")), node12);

        Node node13 = new Node(372, 168,new ArrayList<>(List.of(route11)));
        Route route22 = new Route(100, new ArrayList<>(List.of()), node13);

        Node node14 = new Node(348, 131,new ArrayList<>(List.of(route21,route22)));
        Route route23 = new Route(100, new ArrayList<>(List.of()), node14);

        Node node15 = new Node(293, 71,new ArrayList<>(List.of(route17,route20,route23)));
        Route route24 = new Route(100, new ArrayList<>(List.of()), node15);

        Node node16 = new Node(118, 64,new ArrayList<>(List.of(route18,route24)));

        map = new Map(new ArrayList<>(List.of(node16,node15,node14,node13,node12,node11,node10,node9,node8,node7,node6,node5,node4,node3,node2,node1,node0)),List.of(400, 750, 850),3500);
        return map;
    }
    private Map getMap2R (){
        Node node0 = new Node(332, 335,new ArrayList<>(List.of()));
        Route route1 = new Route(100, new ArrayList<>(List.of("Gravel","Windy")), node0);
        Route route2 = new Route(200, new ArrayList<>(List.of()), node0);

        Node node1 = new Node(156, 329,new ArrayList<>(List.of(route2)));
        Route route3 = new Route(100, new ArrayList<>(List.of()), node1);
        Route route4 = new Route(100, new ArrayList<>(List.of("Mud")), node1);
        Route route5 = new Route(100, new ArrayList<>(List.of("Gravel")), node1);

        Node node2 = new Node(100, 270,new ArrayList<>(List.of(route3)));
        Route route6 = new Route(100, new ArrayList<>(List.of()), node2);
        Route route7 = new Route(100, new ArrayList<>(List.of("Gravel")), node2);

        Node node3 = new Node(77, 231,new ArrayList<>(List.of(route6)));
        Route route8 = new Route(1200, new ArrayList<>(List.of()), node3);

        Node node4 = new Node(141, 260,new ArrayList<>(List.of(route4,route7)));
        Route route9 = new Route(100, new ArrayList<>(List.of()), node4);

        Node node5 = new Node(196, 194,new ArrayList<>(List.of(route9)));
        Route route10 = new Route(100, new ArrayList<>(List.of("Gravel")), node5);

        Node node6 = new Node(308, 287,new ArrayList<>(List.of(route1)));
        Route route11 = new Route(100, new ArrayList<>(List.of("Mud")), node6);
        Route route12 = new Route(100, new ArrayList<>(List.of()), node6);

        Node node7 = new Node(234, 258,new ArrayList<>(List.of(route5,route11)));
        Route route13 = new Route(100, new ArrayList<>(List.of("Mud")), node7);

        Node node8 = new Node(219, 199,new ArrayList<>(List.of(route10,route13)));
        Route route14 = new Route(100, new ArrayList<>(List.of("Gravel")), node8);

        Node node9 = new Node(252, 139,new ArrayList<>(List.of(route14)));
        Route route15 = new Route(100, new ArrayList<>(List.of("Mud")), node9);
        Route route16 = new Route(100, new ArrayList<>(List.of("Gravel","Windy")), node9);

        Node node10 = new Node(241, 108,new ArrayList<>(List.of(route8,route15)));
        Route route17 = new Route(100, new ArrayList<>(List.of()), node10);

        Node node11 = new Node(359, 216,new ArrayList<>(List.of(route12)));
        Route route18 = new Route(100, new ArrayList<>(List.of("Gravel","Windy")), node11);

        Node node12 = new Node(336, 180,new ArrayList<>(List.of(route18)));
        Route route19 = new Route(100, new ArrayList<>(List.of("Mud","Windy")), node12);
        Route route20 = new Route(100, new ArrayList<>(List.of("Gravel","Windy")), node12);

        Node node13 = new Node(290, 127,new ArrayList<>(List.of(route16,route19)));
        Route route21 = new Route(100, new ArrayList<>(List.of("Gravel")), node13);
        Route route22 = new Route(100, new ArrayList<>(List.of("Mud","Windy")), node13);

        Node node14 = new Node(284, 59,new ArrayList<>(List.of(route17,route21)));
        Route route23 = new Route(100, new ArrayList<>(List.of()), node14);

        Node node15 = new Node(347, 118,new ArrayList<>(List.of(route20,route22)));
        Route route24 = new Route(100, new ArrayList<>(List.of("Gravel","Windy")), node15);

        Node node16 = new Node(339, 56,new ArrayList<>(List.of(route23,route24)));

        map = new Map(new ArrayList<>(List.of(node16,node15,node14,node13,node12,node11,node10,node9,node8,node7,node6,node5,node4,node3,node2,node1,node0)),List.of(400, 750, 850),3500);
        return map;
    }
    private Map getMap3 (){
        Node node0 = new Node(21, 381,new ArrayList<>(List.of()));
        Route route1 = new Route(150, new ArrayList<>(List.of()), node0);
        Route route2 = new Route(150, new ArrayList<>(List.of()), node0);

        Node node1 = new Node(37, 299,new ArrayList<>(List.of(route1)));
        Route route3 = new Route(150, new ArrayList<>(List.of()), node1);
        Route route4 = new Route(100, new ArrayList<>(List.of("Ice")), node1);

        Node node2 = new Node(76, 106,new ArrayList<>(List.of(route3)));
        Route route5 = new Route(100, new ArrayList<>(List.of("Ice","Windy")), node2);

        Node node3 = new Node(211, 75,new ArrayList<>(List.of(route5)));
        Route route6 = new Route(100, new ArrayList<>(List.of("Ice")), node3);

        Node node4 = new Node(176, 362,new ArrayList<>(List.of(route2)));
        Route route7 = new Route(100, new ArrayList<>(List.of("Mud","Windy")), node4);
        Route route8 = new Route(150, new ArrayList<>(List.of()), node4);

        Node node5 = new Node(178, 223,new ArrayList<>(List.of(route4,route7)));
        Route route9 = new Route(100, new ArrayList<>(List.of("Mud")), node5);
        Route route10 = new Route(100, new ArrayList<>(List.of("Ice","Windy")), node5);

        Node node6 = new Node(301, 94,new ArrayList<>(List.of(route6,route9)));
        Route route11 = new Route(100, new ArrayList<>(List.of("Ice","Windy")), node6);

        Node node7 = new Node(336, 223,new ArrayList<>(List.of(route8,route10)));
        Route route12 = new Route(100, new ArrayList<>(List.of()), node7);

        Node node8 = new Node(423, 19,new ArrayList<>(List.of(route11,route12)));

        map = new Map(new ArrayList<>(List.of(node8,node7,node6,node5,node4,node3,node2,node1,node0)),List.of(400, 650, 750),3000);
        return map;
    }
    private Map getMap3R (){
        Node node0 = new Node(27, 380,new ArrayList<>(List.of()));
        Route route1 = new Route(150, new ArrayList<>(List.of()), node0);
        Route route2 = new Route(100, new ArrayList<>(List.of("Ice","Windy")), node0);

        Node node1 = new Node(113, 177,new ArrayList<>(List.of(route1)));
        Route route3 = new Route(150, new ArrayList<>(List.of()), node1);
        Route route4 = new Route(100, new ArrayList<>(List.of("Ice","Windy")), node1);

        Node node2 = new Node(148, 305,new ArrayList<>(List.of(route2)));
        Route route5 = new Route(100, new ArrayList<>(List.of("Mud")), node2);
        Route route6 = new Route(100, new ArrayList<>(List.of("Ice")), node2);

        Node node3 = new Node(270, 177,new ArrayList<>(List.of(route4,route5)));
        Route route7 = new Route(100, new ArrayList<>(List.of("Mud")), node3);
        Route route8 = new Route(100, new ArrayList<>(List.of("Ice")), node3);

        Node node4 = new Node(272, 37,new ArrayList<>(List.of(route3,route7)));
        Route route9 = new Route(150, new ArrayList<>(List.of()), node4);

        Node node5 = new Node(238 ,323,new ArrayList<>(List.of(route6)));
        Route route10 = new Route(100, new ArrayList<>(List.of("Ice", "Windy")), node5);

        Node node6 = new Node(374, 294,new ArrayList<>(List.of(route10)));
        Route route11 = new Route(150, new ArrayList<>(List.of()), node6);

        Node node7 = new Node(412, 100,new ArrayList<>(List.of(route8,route11)));
        Route route12 = new Route(150, new ArrayList<>(List.of()), node7);

        Node node8 = new Node(429, 18,new ArrayList<>(List.of(route9,route12)));

        map = new Map(new ArrayList<>(List.of(node8,node7,node6,node5,node4,node3,node2,node1,node0)),List.of(400, 650, 750),3000);
        return map;
    }
    private Map getMap4 (){
        Node node0 = new Node(223, 375,new ArrayList<>(List.of()));
        Route route1 = new Route(150, new ArrayList<>(List.of("Gravel","Steep","Windy")), node0);
        Route route2 = new Route(100, new ArrayList<>(List.of()), node0);

        Node node1 = new Node(183, 259,new ArrayList<>(List.of(route1)));
        Route route3 = new Route(150, new ArrayList<>(List.of("Gravel","Steep","Windy")), node1);
        Route route4 = new Route(100, new ArrayList<>(List.of("Mud","Steep")), node1);
        Route route5 = new Route(100, new ArrayList<>(List.of("Mud","Steep")), node1);

        Node node2 = new Node(92, 146,new ArrayList<>(List.of(route3,route4)));
        Route route6 = new Route(150, new ArrayList<>(List.of("Gravel","Steep","Windy")), node2);

        Node node3 = new Node(309, 360,new ArrayList<>(List.of(route2)));
        Route route7 = new Route(100, new ArrayList<>(List.of("Gravel")), node3);
        Route route8 = new Route(100, new ArrayList<>(List.of()), node3);

        Node node4 = new Node(339, 291,new ArrayList<>(List.of(route7)));
        Route route9 = new Route(100, new ArrayList<>(List.of("Gravel","Windy")), node4);
        Route route10 = new Route(100, new ArrayList<>(List.of("Gravel")), node4);

        Node node5 = new Node(258, 245,new ArrayList<>(List.of(route5,route9)));
        Route route11 = new Route(100, new ArrayList<>(List.of("Mud","Steep")), node5);

        Node node6 = new Node(389, 317,new ArrayList<>(List.of(route8)));
        Route route12 = new Route(100, new ArrayList<>(List.of("Gravel")), node6);

        Node node7 = new Node(361, 209,new ArrayList<>(List.of(route10,route12)));
        Route route13 = new Route(100, new ArrayList<>(List.of("Gravel")), node7);
        Route route14 = new Route(100, new ArrayList<>(List.of("Gravel")), node7);

        Node node8 = new Node(205, 100,new ArrayList<>(List.of(route11,route13)));
        Route route15 = new Route(100, new ArrayList<>(List.of("Gravel")), node8);

        Node node9 = new Node(392, 97,new ArrayList<>(List.of(route14)));
        Route route16 = new Route(300, new ArrayList<>(List.of()), node9);

        Node node10 = new Node(106, 22,new ArrayList<>(List.of(route6,route15,route16)));

        map = new Map(new ArrayList<>(List.of(node10,node9,node8,node7,node6,node5,node4,node3,node2,node1,node0)),List.of(300, 650, 750),3000);
        return map;
    }
    private Map getMap4R (){
        Node node0 = new Node(344, 379,new ArrayList<>(List.of()));
        Route route1 = new Route(200, new ArrayList<>(List.of()), node0);
        Route route2 = new Route(100, new ArrayList<>(List.of("Gravel")), node0);
        Route route3 = new Route(150, new ArrayList<>(List.of("Gravel","Windy","Steep")), node0);

        Node node1 = new Node(57, 302,new ArrayList<>(List.of(route1)));
        Route route4 = new Route(100, new ArrayList<>(List.of("Gravel")), node1);

        Node node2 = new Node(244, 297,new ArrayList<>(List.of(route2)));
        Route route5 = new Route(100, new ArrayList<>(List.of("Gravel")), node2);
        Route route6 = new Route(100, new ArrayList<>(List.of("Mud","Steep")), node2);

        Node node3 = new Node(89, 190,new ArrayList<>(List.of(route4,route5)));
        Route route7 =  new Route(100, new ArrayList<>(List.of("Gravel")), node3);
        Route route8 = new Route(100, new ArrayList<>(List.of("Gravel")), node3);

        Node node4 = new Node(59, 82,new ArrayList<>(List.of(route7)));
        Route route9 = new Route(100, new ArrayList<>(List.of()), node4);

        Node node5 = new Node(191, 155,new ArrayList<>(List.of(route6)));
        Route route10 = new Route(100, new ArrayList<>(List.of("Gravel","Steep","Windy")), node5);
        Route route11 = new Route(100, new ArrayList<>(List.of("Mud","Steep")), node5);

        Node node6 = new Node(111, 109,new ArrayList<>(List.of(route8,route10)));
        Route route12 = new Route(100, new ArrayList<>(List.of("Gravel")), node6);

        Node node7 = new Node(141, 40,new ArrayList<>(List.of(route9,route12)));
        Route route13 = new Route(100, new ArrayList<>(List.of()), node7);

        Node node8 = new Node(357, 253,new ArrayList<>(List.of(route3)));
        Route route14 = new Route(100, new ArrayList<>(List.of("Mud","Steep")), node8);
        Route route15 = new Route(150, new ArrayList<>(List.of("Gravel","Steep","Windy")), node8);

        Node node9 = new Node(266, 139,new ArrayList<>(List.of(route11,route14,route15)));
        Route route16 = new Route(150, new ArrayList<>(List.of("Gravel","Steep","Windy")), node9);

        Node node10 = new Node(226, 24,new ArrayList<>(List.of(route13,route16)));

        map = new Map(new ArrayList<>(List.of(node10,node9,node8,node7,node6,node5,node4,node3,node2,node1,node0)),List.of(300, 650, 750),3000);
        return map;
    }
    private Map getMap5 (){
        Node node0 = new Node(400, 328,new ArrayList<>(List.of()));
        Route route1 = new Route(100, new ArrayList<>(List.of()), node0);
        Route route2 = new Route(100, new ArrayList<>(List.of("Mud")), node0);

        Node node1 = new Node(268, 301,new ArrayList<>(List.of(route1)));
        Route route3 = new Route(100, new ArrayList<>(List.of("Gravel")), node1);
        Route route4 = new Route(100, new ArrayList<>(List.of()), node1);

        Node node2 = new Node(140, 286,new ArrayList<>(List.of(route4)));
        Route route5 = new Route(100, new ArrayList<>(List.of()), node2);
        Route route6 = new Route(100, new ArrayList<>(List.of("Gravel")), node2);

        Node node3 = new Node(56, 279,new ArrayList<>(List.of(route5)));
        Route route7 = new Route(100, new ArrayList<>(List.of("Gravel")), node3);

        Node node4 = new Node(39, 236,new ArrayList<>(List.of(route7)));
        Route route8 = new Route(100, new ArrayList<>(List.of("Gravel","Steep")), node4);
        Route route9 = new Route(100, new ArrayList<>(List.of("Mud")), node4);

        Node node5 = new Node(37, 189,new ArrayList<>(List.of(route8)));
        Route route10 = new Route(100, new ArrayList<>(List.of("Ice","Steep","Windy")), node5);

        Node node6 = new Node(40, 125,new ArrayList<>(List.of(route10)));
        Route route11 = new Route(100, new ArrayList<>(List.of("Gravel","Steep")), node6);

        Node node7 = new Node(158, 236,new ArrayList<>(List.of(route6)));
        Route route14 = new Route(100, new ArrayList<>(List.of("Mud","Windy")), node7);
        Route route15 = new Route(100, new ArrayList<>(List.of("Gravel")), node7);

        Node node8 = new Node(123, 180,new ArrayList<>(List.of(route9,route14)));
        Route route16 = new Route(100, new ArrayList<>(List.of("Ice","Steep")), node8);

        Node node9 = new Node(114, 116,new ArrayList<>(List.of(route16)));
        Route route17 = new Route(100, new ArrayList<>(List.of("Mud","Steep","Windy")), node9);

        Node node10 = new Node(200, 210,new ArrayList<>(List.of(route15)));
        Route route18 = new Route(100, new ArrayList<>(List.of("Mud","Steep","Windy")), node10);

        Node node11 = new Node(216, 105,new ArrayList<>(List.of(route18)));
        Route route19 = new Route(100,new ArrayList<>(List.of("Gravel")),node11);

        Node node12 = new Node(403, 180,new ArrayList<>(List.of(route2,route3)));
        Route route20 = new Route(200, new ArrayList<>(List.of("Gravel")), node12);

        Node node13 = new Node(217, 58,new ArrayList<>(List.of(route19,route20)));
        Route route21 = new Route(200, new ArrayList<>(List.of("Gravel")), node13);

        Node node14 = new Node(44, 72,new ArrayList<>(List.of(route11,route17,route21)));

        map = new Map(new ArrayList<>(List.of(node14,node13,node12,node11,node10,node9,node8,node7,node6,node5,node4,node3,node2,node1,node0)),List.of(300, 600, 700),4000);
        return map;
    }
    private Map getMap5R (){
        Node node0 = new Node(405, 327,new ArrayList<>(List.of()));
        Route route1 = new Route(200, new ArrayList<>(List.of("Gravel")), node0);
        Route route2 = new Route(100, new ArrayList<>(List.of("Mud","Windy","Steep")), node0);
        Route route3 = new Route(100, new ArrayList<>(List.of("Gravel","Steep")), node0);

        Node node1 = new Node(232, 341,new ArrayList<>(List.of(route1)));
        Route route4 =  new Route(200, new ArrayList<>(List.of("Gravel")), node1);
        Route route5 = new Route(100, new ArrayList<>(List.of("Gravel")), node1);

        Node node2 = new Node(47, 219,new ArrayList<>(List.of(route4)));
        Route route6 = new Route(100, new ArrayList<>(List.of("Mud")), node2);
        Route route7 = new Route(100, new ArrayList<>(List.of("Gravel")), node2);

        Node node3 = new Node(233, 394,new ArrayList<>(List.of(route5)));
        Route route8 = new Route(100, new ArrayList<>(List.of("Mud","Windy","Steep")), node3);

        Node node4 = new Node(249, 190,new ArrayList<>(List.of(route8)));
        Route route9 = new Route(100, new ArrayList<>(List.of("Gravel")), node4);

        Node node5 = new Node(335, 282,new ArrayList<>(List.of(route2)));
        Route route10 = new Route(100, new ArrayList<>(List.of("Ice","Steep")), node5);

        Node node6 = new Node(326, 219,new ArrayList<>(List.of(route10)));
        Route route11 = new Route(100, new ArrayList<>(List.of("Mud","Steep","Windy")), node6);
        Route route12 = new Route(100, new ArrayList<>(List.of("Mud","Steep")), node6);

        Node node7 = new Node(291, 164,new ArrayList<>(List.of(route9,route11)));
        Route route14 = new Route(100, new ArrayList<>(List.of("Gravel")), node7);

        Node node8 = new Node(405, 274,new ArrayList<>(List.of(route3)));
        Route route16 = new Route(100, new ArrayList<>(List.of("Ice","Windy","Steep")), node8);

        Node node9 = new Node(412, 209,new ArrayList<>(List.of(route16)));
        Route route17 = new Route(100, new ArrayList<>(List.of("Gravel","Steep")), node9);

        Node node10 = new Node(410, 164,new ArrayList<>(List.of(route12,route17)));
        Route route18 = new Route(100, new ArrayList<>(List.of("Gravel")), node10);

        Node node11 = new Node(392, 120,new ArrayList<>(List.of(route18)));
        Route route19 = new Route(100, new ArrayList<>(List.of()), node11);

        Node node12 = new Node(309, 114,new ArrayList<>(List.of(route14,route19)));
        Route route20 = new Route(100, new ArrayList<>(List.of()), node12);

        Node node13 = new Node(182, 98,new ArrayList<>(List.of(route7,route20)));
        Route route21 = new Route(100, new ArrayList<>(List.of()), node13);

        Node node14 = new Node(49, 71,new ArrayList<>(List.of(route6,route21)));

        map = new Map(new ArrayList<>(List.of(node14,node13,node12,node11,node10,node9,node8,node7,node6,node5,node4,node3,node2,node1,node0)),List.of(300, 600, 700),4000);
        return map;
    }
    private Map getMap6 (){
        Node node0 = new Node(402,365,new ArrayList<>(List.of()));
        Route route1 = new Route(100, new ArrayList<>(List.of("Gravel")), node0);
        Route route2 = new Route(100, new ArrayList<>(List.of("Gravel")), node0);

        Node node1 = new Node(278, 357,new ArrayList<>(List.of(route1)));
        Route route3 = new Route(100, new ArrayList<>(List.of("Mud")), node1);
        Route route4 = new Route(100, new ArrayList<>(List.of("Mud","Windy")), node1);

        Node node2 = new Node(378, 209,new ArrayList<>(List.of(route2)));
        Route route5 = new Route(100, new ArrayList<>(List.of("Mud","Windy")), node2);
        Route route6 = new Route(100, new ArrayList<>(List.of("Gravel")), node2);

        Node node3 = new Node(269, 242,new ArrayList<>(List.of(route4,route5)));
        Route route7 = new Route(100, new ArrayList<>(List.of("Mud")), node3);

        Node node4 = new Node(360, 129,new ArrayList<>(List.of(route6)));
        Route route8 = new Route(100, new ArrayList<>(List.of("Mud")), node4);
        Route route9 = new Route(100, new ArrayList<>(List.of("Gravel","Windy")), node4);

        Node node5 = new Node(253, 195,new ArrayList<>(List.of(route7,route8)));
        Route route10 = new Route(100, new ArrayList<>(List.of("Gravel")), node5);
        Route route11 = new Route(100, new ArrayList<>(List.of("Mud","Windy")), node5);

        Node node6 = new Node(64, 253,new ArrayList<>(List.of(route3,route10)));
        Route route12 = new Route(200, new ArrayList<>(List.of("Mud")), node6);

        Node node7 = new Node(169, 50,new ArrayList<>(List.of(route9)));
        Route route14 = new Route(100, new ArrayList<>(List.of("Gravel","Windy")), node7);
        Route route16 = new Route(100, new ArrayList<>(List.of("Gravel")), node7);

        Node node8 = new Node(124, 144,new ArrayList<>(List.of(route11,route16)));
        Route route17 = new Route(100, new ArrayList<>(List.of("Mud")), node8);

        Node node9 = new Node(63, 16,new ArrayList<>(List.of(route14)));
        Route route18 = new Route(100, new ArrayList<>(List.of()), node9);

        Node node10 = new Node(40, 30,new ArrayList<>(List.of(route12,route17,route18)));

        map = new Map(new ArrayList<>(List.of(node10,node9,node8,node7,node6,node5,node4,node3,node2,node1,node0)),List.of(400, 600, 700),4500);
        return map;
    }
    private Map getMap6R (){
        Node node0 = new Node(409, 369,new ArrayList<>(List.of()));
        Route route1 = new Route(100, new ArrayList<>(List.of()), node0);
        Route route2 = new Route(100, new ArrayList<>(List.of("Mud")), node0);
        Route route3 = new Route(200, new ArrayList<>(List.of("Mud")), node0);

        Node node1 = new Node(387, 384 ,new ArrayList<>(List.of(route1)));
        Route route4 = new Route(100, new ArrayList<>(List.of("Gravel","Windy")), node1);

        Node node2 = new Node(324, 286,new ArrayList<>(List.of(route2)));
        Route route5 = new Route(100, new ArrayList<>(List.of("Mud","Windy")), node2);
        Route route6 = new Route(100, new ArrayList<>(List.of("Gravel")), node2);

        Node node3 = new Node(280, 349,new ArrayList<>(List.of(route4,route6)));
        Route route7 = new Route(100, new ArrayList<>(List.of("Gravel","Windy")), node3);

        Node node4 = new Node(386, 146,new ArrayList<>(List.of(route3)));
        Route route8 = new Route(100, new ArrayList<>(List.of("Gravel")), node4);
        Route route9 = new Route(100, new ArrayList<>(List.of("Mud")), node4);

        Node node5 = new Node(196, 204,new ArrayList<>(List.of(route5,route8)));
        Route route10 = new Route(100, new ArrayList<>(List.of("Mud")), node5);
        Route route11 = new Route(100, new ArrayList<>(List.of("Mud","Windy")), node5);

        Node node6 = new Node(90, 270,new ArrayList<>(List.of(route7,route10)));
        Route route12 = new Route(100, new ArrayList<>(List.of("Gravel")), node6);

        Node node7 = new Node(180, 156,new ArrayList<>(List.of(route11)));
        Route route14 = new Route(100, new ArrayList<>(List.of("Mud","Windy")), node7);
        Route route16 = new Route(100, new ArrayList<>(List.of("Mud","Windy")), node7);

        Node node8 = new Node(72, 190,new ArrayList<>(List.of(route12,route14)));
        Route route17 = new Route(100, new ArrayList<>(List.of("Gravel")), node8);

        Node node9 = new Node(172, 42,new ArrayList<>(List.of(route9,route16)));
        Route route18 = new Route(100, new ArrayList<>(List.of("Gravel")), node9);

        Node node10 = new Node(48, 34,new ArrayList<>(List.of(route17,route18)));

        map = new Map(new ArrayList<>(List.of(node10,node9,node8,node7,node6,node5,node4,node3,node2,node1,node0)),List.of(400, 600, 700),4500);
        return map;
    }
    private Map getMap7 (){
        Node node0 = new Node(411, 350,new ArrayList<>(List.of()));
        Route route1 = new Route(100, new ArrayList<>(List.of()), node0);

        Node node1 = new Node(330, 377, new ArrayList<>(List.of(route1)));
        Route route2 = new Route(100, new ArrayList<>(List.of()), node1);
        Route route3 = new Route(100, new ArrayList<>(List.of("Mud","Windy","Steep")), node1);

        Node node2 = new Node(206, 370, new ArrayList<>(List.of(route2)));
        Route route4 = new Route(100, new ArrayList<>(List.of()), node2);
        Route route5 = new Route(100, new ArrayList<>(List.of("Mud","Steep")), node2);

        Node node3 = new Node(347, 279,new ArrayList<>(List.of(route3,route5)));
        Route route6 = new Route(100, new ArrayList<>(List.of("Ice","Steep","Windy")), node3);

        Node node4 = new Node(346, 205,new ArrayList<>(List.of(route6)));
        Route route7 = new Route(100, new ArrayList<>(List.of("Mud","Steep","Windy")), node4);

        Node node5 = new Node(360, 137,new ArrayList<>(List.of(route7)));
        Route route8 = new Route(100, new ArrayList<>(List.of("Ice","Steep","Windy")), node5);
        Route route9 = new Route(100, new ArrayList<>(List.of("Mud","Steep")), node5);

        Node node6 = new Node(278, 37,new ArrayList<>(List.of(route8,route9)));
        Route route10 = new Route(100, new ArrayList<>(List.of("Mud")), node6);

        Node node7 = new Node(123, 357,new ArrayList<>(List.of(route4)));
        Route route11 = new Route(100, new ArrayList<>(List.of()), node7);
        Route route12 = new Route(100, new ArrayList<>(List.of("Gravel")), node7);

        Node node8 = new Node(128, 286,new ArrayList<>(List.of(route12)));
        Route route14 = new Route(10, new ArrayList<>(List.of()), node8);

        Node node9 = new Node(139, 277,new ArrayList<>(List.of(route14)));
        Route route15 = new Route(100, new ArrayList<>(List.of("Gravel")), node9);

        Node node10 = new Node(172, 206,new ArrayList<>(List.of(route15)));
        Route route16 = new Route(10, new ArrayList<>(List.of()), node10);

        Node node11 = new Node(177, 178,new ArrayList<>(List.of(route16)));
        Route route17 = new Route(100, new ArrayList<>(List.of("Gravel","Steep")), node11);
        Route route18 = new Route(100, new ArrayList<>(List.of("Gravel","Steep","Windy")), node11);

        Node node12 = new Node(249, 145,new ArrayList<>(List.of(route18)));
        Route route19 = new Route(100, new ArrayList<>(List.of("Ice","Steep","Windy")), node12);

        Node node13 = new Node(224, 102,new ArrayList<>(List.of(route19)));
        Route route20 = new Route(100, new ArrayList<>(List.of("Gravel")), node13);

        Node node14 = new Node(155, 57,new ArrayList<>(List.of(route10,route20)));
        Route route21 = new Route(100, new ArrayList<>(List.of("Gravel","Steep","Windy")), node14);

        Node node15 = new Node(63, 363,new ArrayList<>(List.of(route11)));
        Route route22 = new Route(100, new ArrayList<>(List.of("Gravel","Steep","Windy")), node15);

        Node node16 = new Node(63, 283,new ArrayList<>(List.of(route22)));
        Route route23 = new Route(100, new ArrayList<>(List.of("Gravel","Steep","Windy")), node16);
        Route route24 = new Route(100, new ArrayList<>(List.of("Ice","Steep","Windy")), node16);

        Node node17 = new Node(70, 199,new ArrayList<>(List.of(route17,route23,route24)));
        Route route25 = new Route(100, new ArrayList<>(List.of("Ice","Steep","Windy")), node17);

        Node node18 = new Node(80, 106,new ArrayList<>(List.of(route25)));
        Route route26 = new Route(100, new ArrayList<>(List.of("Mud","Steep","Windy")), node18);

        Node node19 = new Node(28, 19,new ArrayList<>(List.of(route21,route26)));

        map = new Map(new ArrayList<>(List.of(node19,node18,node17,node16,node15,node14,node13,node12,node11,node10,node9,node8,node7,node6,node5,node4,node3,node2,node1,node0)),List.of(450, 650, 750),4000);
        return map;
    }
    private Map getMap7R (){
        Node node0 = new Node(422, 379,new ArrayList<>(List.of()));
        Route route1 = new Route(100, new ArrayList<>(List.of("Gravel","Windy","Steep")), node0);
        Route route2 = new Route(100, new ArrayList<>(List.of("Mud","Windy","Steep")), node0);

        Node node1 = new Node(294, 342, new ArrayList<>(List.of(route1)));
        Route route3 = new Route(100, new ArrayList<>(List.of("Mud")), node1);
        Route route4 = new Route(100, new ArrayList<>(List.of("Gravel")), node1);

        Node node2 = new Node(171, 361, new ArrayList<>(List.of(route3)));
        Route route5 = new Route(100, new ArrayList<>(List.of("Mud","Steep")), node2);
        Route route6 = new Route(100, new ArrayList<>(List.of("Ice","Steep","Windy")), node2);

        Node node3 = new Node(87, 263,new ArrayList<>(List.of(route5,route6)));
        Route route7 = new Route(100, new ArrayList<>(List.of("Mud","Steep","Windy")), node3);

        Node node4 = new Node(103, 194,new ArrayList<>(List.of(route7)));
        Route route8 = new Route(100, new ArrayList<>(List.of("Ice","Windy","Steep")), node4);

        Node node5 = new Node(103, 120,new ArrayList<>(List.of(route8)));
        Route route9 = new Route(100, new ArrayList<>(List.of("Mud","Windy","Steep")), node5);
        Route route10 = new Route(100, new ArrayList<>(List.of("Mud","Steep")), node5);

        Node node6 = new Node(224, 297,new ArrayList<>(List.of(route4)));
        Route route11 = new Route(100, new ArrayList<>(List.of("Ice", "Windy","Steep")), node6);

        Node node7 = new Node(200, 254,new ArrayList<>(List.of(route11)));
        Route route12 = new Route(100, new ArrayList<>(List.of("Gravel","Windy","Steep")), node7);

        Node node8 = new Node(369, 293,new ArrayList<>(List.of(route2)));
        Route route13 = new Route(100, new ArrayList<>(List.of("Ice","Windy","Steep")), node8);

        Node node9 = new Node(380, 201,new ArrayList<>(List.of(route13)));
        Route route14 = new Route(100, new ArrayList<>(List.of("Gravel","Steep")), node9);
        Route route15 = new Route(100, new ArrayList<>(List.of("Ice","Steep","Windy")), node9);
        Route route16 = new Route(100, new ArrayList<>(List.of("Gravel","Steep","Windy")), node9);

        Node node10 = new Node(273, 221,new ArrayList<>(List.of(route12,route14)));
        Route route17 = new Route(10, new ArrayList<>(List.of()), node10);

        Node node11 = new Node(277, 193,new ArrayList<>(List.of(route17)));
        Route route18 = new Route(100, new ArrayList<>(List.of("Gravel")), node11);

        Node node12 = new Node(310, 123,new ArrayList<>(List.of(route18)));
        Route route19 = new Route(10, new ArrayList<>(List.of()), node12);

        Node node13 = new Node(321, 114,new ArrayList<>(List.of(route19)));
        Route route20 = new Route(100, new ArrayList<>(List.of("Gravel")), node13);

        Node node14 = new Node(386, 116,new ArrayList<>(List.of(route15,route16)));
        Route route21 = new Route(100, new ArrayList<>(List.of("Gravel","Steep")), node14);

        Node node15 = new Node(386, 36,new ArrayList<>(List.of(route21)));
        Route route22 = new Route(100, new ArrayList<>(List.of()), node15);

        Node node16 = new Node(326, 41,new ArrayList<>(List.of(route20,route22)));
        Route route23 = new Route(100, new ArrayList<>(List.of()), node16);

        Node node17 = new Node(244, 28,new ArrayList<>(List.of(route10,route23)));
        Route route24 = new Route(100, new ArrayList<>(List.of()), node17);

        Node node18 = new Node(119, 22,new ArrayList<>(List.of(route9,route24)));
        Route route25 = new Route(100, new ArrayList<>(List.of()), node18);

        Node node19 = new Node(38, 49,new ArrayList<>(List.of(route25)));

        map = new Map(new ArrayList<>(List.of(node19,node18,node17,node16,node15,node14,node13,node12,node11,node10,node9,node8,node7,node6,node5,node4,node3,node2,node1,node0)),List.of(450, 650, 750),4000);
        return map;
    }
    private Map getMap8 (){
        Node node0 = new Node(48, 367, new ArrayList<>(List.of()));
        Route route1 = new Route(100, new ArrayList<>(List.of("Mud")), node0);
        Route route2 = new Route(100, new ArrayList<>(List.of()), node0);

        Node node1 = new Node(46, 261, new ArrayList<>(List.of(route1)));
        Route route3 = new Route(100, new ArrayList<>(List.of("Ice","Steep")), node1);
        Route route4 = new Route(100, new ArrayList<>(List.of("Gravel","Windy","Steep")), node1);

        Node node2 = new Node(89, 198,new ArrayList<>(List.of(route3)));
        Route route5 = new Route(100, new ArrayList<>(List.of("Ice","Steep")), node2);
        Route route6 = new Route(100, new ArrayList<>(List.of("Gravel","Steep","Windy")), node2);

        Node node3 = new Node(73, 113,new ArrayList<>(List.of(route5)));
        Route route7 = new Route(100, new ArrayList<>(List.of("Mud")), node3);

        Node node4 = new Node(178, 377,new ArrayList<>(List.of(route2)));
        Route route8 = new Route(100, new ArrayList<>(List.of("Gravel","Steep","Windy")), node4);
        Route route9 = new Route(200, new ArrayList<>(List.of()), node4);

        Node node5 = new Node(200, 292,new ArrayList<>(List.of(route4,route8)));
        Route route10 = new Route(100, new ArrayList<>(List.of("Ice","Steep","Windy")), node5);

        Node node6 = new Node(175, 126,new ArrayList<>(List.of(route6,route10)));
        Route route11 = new Route(100, new ArrayList<>(List.of("Gravel","Windy")), node6);

        Node node7 = new Node(173, 39,new ArrayList<>(List.of(route7,route11)));
        Route route12 = new Route(100, new ArrayList<>(List.of("Gravel")), node7);

        Node node8 = new Node(351, 263,new ArrayList<>(List.of(route9)));
        Route route13 = new Route(25, new ArrayList<>(List.of("Gravel","Windy")), node8);
        Route route14 = new Route(150, new ArrayList<>(List.of("Windy")), node8);
        Route route15 = new Route(100, new ArrayList<>(List.of("Gravel","Windy","Steep")), node8);

        Node node9 = new Node(300, 238,new ArrayList<>(List.of(route13)));
        Route route16 = new Route(50, new ArrayList<>(List.of("Ice","Windy")), node9);

        Node node10 = new Node(294, 187,new ArrayList<>(List.of(route16)));
        Route route17 = new Route(25, new ArrayList<>(List.of("Gravel","Windy")), node10);

        Node node11 = new Node(333, 135,new ArrayList<>(List.of(route14,route15,route17)));
        Route route18 = new Route(100, new ArrayList<>(List.of()), node11);

        Node node12 = new Node(319, 69,new ArrayList<>(List.of(route12,route18)));

        map = new Map (new ArrayList<>(List.of(node12,node11,node10,node9,node8,node7,node6,node5,node4,node3,node2,node1,node0)),List.of(300, 599, 700),3000);
        return map;
    }
    private Map getMap8R (){
        Node node0 = new Node(131, 330, new ArrayList<>(List.of()));
        Route route1 = new Route(100, new ArrayList<>(List.of()), node0);
        Route route2 = new Route(100, new ArrayList<>(List.of("Gravel")), node0);

        Node node1 = new Node(117, 245, new ArrayList<>(List.of(route1)));
        Route route3 = new Route(100, new ArrayList<>(List.of("Gravel","Steep")), node1);
        Route route4 = new Route(150, new ArrayList<>(List.of("Windy")), node1);
        Route route5 = new Route(100, new ArrayList<>(List.of("Gravel","Steep")), node1);

        Node node2 = new Node(156, 212,new ArrayList<>(List.of(route5)));
        Route route6 = new Route(100, new ArrayList<>(List.of("Steep","Ice","Windy")), node2);

        Node node3 = new Node(149, 162,new ArrayList<>(List.of(route6)));
        Route route7 = new Route(100, new ArrayList<>(List.of("Gravel","Steep")), node3);

        Node node4 = new Node(99, 137,new ArrayList<>(List.of(route3,route4,route7)));
        Route route8 = new Route(200, new ArrayList<>(List.of()), node4);

        Node node5 = new Node(276, 360,new ArrayList<>(List.of(route2)));
        Route route9 = new Route(100, new ArrayList<>(List.of("Gravel","Windy")), node5);
        Route route10 = new Route(100, new ArrayList<>(List.of("Mud")), node5);

        Node node6 = new Node(275, 274,new ArrayList<>(List.of(route9)));
        Route route11 = new Route(100, new ArrayList<>(List.of("Ice", "Windy","Steep")), node6);
        Route route12 = new Route(100, new ArrayList<>(List.of("Gravel", "Windy","Steep")), node6);

        Node node7 = new Node(376, 286,new ArrayList<>(List.of(route10)));
        Route route13 = new Route(100, new ArrayList<>(List.of("Ice","Steep")), node7);

        Node node8 = new Node(360, 201,new ArrayList<>(List.of(route12,route13)));
        Route route14 = new Route(100, new ArrayList<>(List.of("Ice","Steep")), node8);

        Node node9 = new Node(249, 107,new ArrayList<>(List.of(route11)));
        Route route15 = new Route(100, new ArrayList<>(List.of("Gravel","Windy","Steep")), node9);
        Route route16 = new Route(100, new ArrayList<>(List.of("Gravel","Windy","Steep")), node9);

        Node node10 = new Node(404, 137,new ArrayList<>(List.of(route14,route16)));
        Route route17 = new Route(100, new ArrayList<>(List.of("Mud","Steep")), node10);

        Node node11 = new Node(271, 23,new ArrayList<>(List.of(route8,route15)));
        Route route18 = new Route(100, new ArrayList<>(List.of()), node11);

        Node node12 = new Node(401, 33,new ArrayList<>(List.of(route17,route18)));

        map = new Map (new ArrayList<>(List.of(node12,node11,node10,node9,node8,node7,node6,node5,node4,node3,node2,node1,node0)),List.of(300, 599, 700),3000);
        return map;
    }
    private Map getFinalMap (){
        Node node0 = new Node(410, 34, List.of());
        Route route1 = new Route(100, List.of("Gravel"), node0);
        Route route2 = new Route(100, List.of("Gravel"), node0);
        Route route3 = new Route(250, List.of("Gravel"), node0);
        Route route4 = new Route(350, List.of(), node0);

        Node node1 = new Node(334, 37, List.of(route1));
        Route route5 = new Route(100, List.of("Ice", "Windy", "Steep"), node1);

        Node node2 = new Node(308, 67, List.of(route2));
        Route route6 = new Route(100, List.of("Gravel", "Steep"), node2);
        Route route7 = new Route(100, List.of("ice", "Windy", "Steep"), node2);

        Node node3 = new Node(327, 227, List.of(route3));
        Route route8 = new Route(100, List.of("Gravel"), node3);
        Route route9 = new Route(100, List.of("Gravel"), node3);
        Route route10 = new Route(50, List.of("Gravel"), node3);
        Route route11 = new Route(100, List.of("Gravel"), node3);

        Node node4 = new Node(388, 361, List.of(route4));
        Route route12 = new Route(100, List.of("Gravel"), node4);

        Node node5 = new Node(272, 23, List.of(route5));
        Route route13 = new Route(100, List.of("Mud"), node5);

        Node node6 = new Node(297, 181, List.of(route8));
        Route route14 = new Route(100, List.of("Mud", "Windy", "Steep"), node6);

        Node node7 = new Node(249, 277, List.of(route9));
        Route route15 = new Route(100, List.of("Gravel"), node7);
        Route route16 = new Route(100, List.of("Gravel"), node7);

        Node node8 = new Node(316, 274, List.of(route10));
        Route route17 = new Route(100, List.of("Ice", "windy", "Steep"), node8);

        Node node9 = new Node(332, 360, List.of(route11, route12));
        Route route18 = new Route(100, List.of("Mud", "Windy", "Steep"), node9);

        Node node10 = new Node(235, 66, List.of(route13, route6));
        Route route19 = new Route(150, List.of("Mud", "Windy"), node10);

        Node node11 = new Node(265, 159, List.of(route7, route14));
        Route route20 = new Route(150, List.of("Mud", "Windy"), node11);
        Route route21 = new Route(100, List.of("Mud"), node11);

        Node node12 = new Node(287, 350, List.of(route17));
        Route route22 = new Route(50, List.of("Gravel", "Windy", "Steep"), node12);

        Node node13 = new Node(287, 350, List.of(route21, route15));
        Route route23 = new Route(100, List.of("Mud"), node13);
        Route route24 = new Route(100, List.of("Gravel"), node13);

        Node node14 = new Node(266, 372, List.of(route22, route18));
        Route route25 = new Route(100, List.of("Gravel"), node14);

        Node node15 = new Node(151, 135, List.of(route19, route20, route23));
        Route route26 = new Route(100, List.of("Gravel"), node15);

        Node node16 = new Node(200, 357, List.of(route16, route25));
        Route route27 = new Route(100, List.of("Mud", "Windy", "Steep"), node16);

        Node node17 = new Node(71, 373, List.of(route27));
        Route route28 = new Route(100, List.of("Gravel"), node17);

        Node node18 = new Node(65, 228, List.of(route24, route28));
        Route route29 = new Route(100, List.of(), node18);

        Node node19 = new Node(84, 118, List.of(route26, route29));
        Route route30 = new Route(100, List.of(), node19);

        Node node20 = new Node(72, 35, List.of(route30));



        map = new Map(new ArrayList<>(List.of(node20,node19,node18,node17,node16,node15,node14,node13,node12,node11,node10,node9,node8,node7,node6,node5,node4,node3,node2,node1,node0)),List.of(500, 700, 800),6000);
        return map;
    }
}

