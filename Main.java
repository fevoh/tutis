import org.dreambot.api.Client;
import org.dreambot.api.ClientSettings;
import org.dreambot.api.input.Mouse;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.container.impl.equipment.Equipment;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.api.methods.dialogues.Dialogues;
import org.dreambot.api.methods.filter.Filter;
import org.dreambot.api.methods.input.Camera;
import org.dreambot.api.methods.input.Keyboard;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.item.GroundItems;
import org.dreambot.api.methods.magic.Magic;
import org.dreambot.api.methods.magic.Normal;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Map;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.methods.prayer.Prayer;
import org.dreambot.api.methods.prayer.Prayers;
import org.dreambot.api.methods.settings.PlayerSettings;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.tabs.Tabs;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.methods.widget.Widget;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.randoms.RandomEvent;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.utilities.Sleep;
import org.dreambot.api.utilities.Timer;
import org.dreambot.api.utilities.impl.Condition;
import org.dreambot.api.wrappers.interactive.Entity;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.wrappers.interactive.NPC;
import org.dreambot.api.wrappers.items.GroundItem;
import org.dreambot.api.wrappers.items.Item;
import org.dreambot.api.wrappers.widgets.Menu;
import org.dreambot.api.wrappers.widgets.WidgetChild;

import java.awt.*;
import java.util.List;


@ScriptManifest(version = 1.7, author = "Fevohib", category = Category.MINING, name = "Tutorial Crash n Burn")
public class Main extends AbstractScript {

    RandomName rn = new RandomName();
    private final int TAB_CONFIG = 1021;
    private final int PERC_COMP = 406;
    private final int ATT_SPEED = 843;
    private final int POLL_OPEN = 375;
    private final int TUT_PROG = 281;
    private final int TUT_PROG_NEW = 2686;

    private final int TUT_PROG_MAJOR = 2687;
    private final int TUT_PROG_MINOR = 2686;


    private final int APPEAR_PAR = 269;
    private final int[][] appChildren = {{106, 113}, {107, 114}, {108, 115}, {109, 116}, {110, 117}, {111, 118}, {112, 119}, {105, 121}, {123, 127}, {122, 129}, {124, 130}, {125, 131}};
    private final int ACCEPT = 100;

    private final String RUNESCAPE_GUIDE = "Gielinor Guide";
    private final String SURVIVAL_EXPERT = "Survival Expert";
    private final String COOK_GUIDE = "Master Chef";
    private final String MASTER_NAVIGATOR = "Master Navigator";
    private final String QUEST_GUIDE = "Quest Guide";
    private final String MINING_GUIDE = "Mining Instructor";
    private final String COMBAT_GUIDE = "Combat Instructor";
    private final String FINANCIAL_GUIDE = "Account Guide";
    private final String PRAY_GUIDE = "Brother Brace";
    private final String MAGIC_GUIDE = "Magic Instructor";

    Tile[] cookToQuest = new Tile[]{new Tile(3072, 3090, 0), new Tile(3072, 3092, 0), new Tile(3072, 3094, 0), new Tile(3071, 3095, 0), new Tile(3071, 3097, 0), new Tile(3071, 3099, 0), new Tile(3071, 3101, 0), new Tile(3071, 3103, 0), new Tile(3072, 3104, 0), new Tile(3073, 3105, 0), new Tile(3074, 3106, 0), new Tile(3076, 3106, 0), new Tile(3077, 3107, 0), new Tile(3077, 3109, 0), new Tile(3077, 3111, 0), new Tile(3077, 3113, 0), new Tile(3077, 3115, 0), new Tile(3077, 3117, 0), new Tile(3076, 3119, 0), new Tile(3076, 3121, 0), new Tile(3076, 3123, 0), new Tile(3077, 3125, 0), new Tile(3079, 3125, 0), new Tile(3080, 3126, 0), new Tile(3082, 3126, 0), new Tile(3084, 3126, 0), new Tile(3086, 3126, 0)};
    Tile[] combatToLadder = new Tile[]{new Tile(3106, 9509, 0), new Tile(3107, 9510, 0), new Tile(3108, 9511, 0), new Tile(3109, 9512, 0), new Tile(3110, 9513, 0), new Tile(3111, 9515, 0), new Tile(3112, 9516, 0), new Tile(3112, 9518, 0), new Tile(3112, 9520, 0), new Tile(3112, 9522, 0), new Tile(3112, 9524, 0), new Tile(3111, 9525, 0)};
    Tile[] finToPray = new Tile[]{new Tile(3130, 3124, 0), new Tile(3132, 3124, 0), new Tile(3133, 3123, 0), new Tile(3133, 3121, 0), new Tile(3134, 3119, 0), new Tile(3134, 3117, 0), new Tile(3133, 3115, 0), new Tile(3132, 3114, 0), new Tile(3131, 3113, 0), new Tile(3131, 3111, 0), new Tile(3130, 3110, 0), new Tile(3130, 3108, 0)};
    Tile[] prayToMage = new Tile[]{new Tile(3122, 3102, 0), new Tile(3123, 3101, 0), new Tile(3124, 3100, 0), new Tile(3125, 3099, 0), new Tile(3126, 3098, 0), new Tile(3127, 3097, 0), new Tile(3128, 3096, 0), new Tile(3129, 3095, 0), new Tile(3130, 3094, 0), new Tile(3132, 3094, 0), new Tile(3133, 3093, 0), new Tile(3134, 3092, 0), new Tile(3135, 3091, 0), new Tile(3136, 3090, 0), new Tile(3137, 3089, 0), new Tile(3138, 3088, 0), new Tile(3140, 3087, 0), new Tile(3141, 3088, 0)};


    public static final Rectangle GAME_SCREEN = new Rectangle(5, 5, 511, 333);
    public static final Rectangle CANVAS = new Rectangle(0, 0, 765, 503);

    private final boolean hover = false;

    private final boolean forceEmail = false;

    private int conf;

    boolean started = false;
    boolean accMade = false;
    boolean inNewTutorial = false;
    private State state;
    private Timer t;

    private enum State {
        CREATE_ACC, OPEN_TAB, DO_TUT
    }

    private State getState() {
        if (!started) {
            return State.CREATE_ACC;
        }
//        if (PlayerSettings.getConfig(TAB_CONFIG) > 0) {
//            return State.OPEN_TAB;
//        }
        return State.DO_TUT;
    }

    @Override
    public void onStart() {
        getRandomManager().disableSolver(RandomEvent.RESIZABLE_DISABLER);
        accMade = true;
        started = true;
        t = new Timer();
    }


    private WidgetChild getClickHereToContinue() {
        if (!Dialogues.inDialogue()) {
            log("Not in dialogue");
            return null;
        }
        List<WidgetChild> children = Widgets.getWidgetChildrenContainingText("Click here to continue");
        if (children.isEmpty()) {
            children = Widgets.getWidgetChildrenContainingText("Click to continue");
        }
        if (children.isEmpty()) {
            return null;
        }
        for (WidgetChild wc : children) {
            if (wc.isVisible()) {
                if (wc.getParentID() != 137) {
                    if (wc.isGrandChild()) {
                        if (wc.getID() != 107 && wc.isVisible())
                            return wc;
                    } else if (wc.isVisible()) {
                        return wc;
                    }
                }
            }
        }
        children = Widgets.getWidgetChildrenContainingText("Click to continue");
        for (WidgetChild wc : children) {
            if (wc.isVisible()) {
                if (wc.getParentID() != 137) {
                    if (wc.isGrandChild()) {
                        if (wc.getID() != 107 && wc.isVisible())
                            return wc;
                    } else if (wc.isVisible()) {
                        return wc;
                    }
                }
            }
        }
        return null;
    }

    private boolean isRoofEnabled() {
        return false;
    }

    private int toggleRoof() {
        if (!isRoofEnabled())
            return -1;

        return -1;
    }

    private int makeAccount() {
        Sleep.sleepUntil(new Condition() {
            public boolean verify() {
                return Widgets.getWidget(APPEAR_PAR) != null;
            }
        }, 30000);
        return Calculations.random(250, 350);
    }

    private boolean inNewTutorial() {
        return PlayerSettings.getConfig(TUT_PROG_NEW) > PlayerSettings.getConfig(TUT_PROG);
    }

    @Override
    public int onLoop() {
        state = getState();
        log("Current State: " + state);

        if (Dialogues.inDialogue() && !Players.getLocal().isInCombat() && !Players.getLocal().isHealthBarVisible()) {
            if (Dialogues.canContinue()) {
                log("Space to continue");
                Dialogues.spaceToContinue();
                return Calculations.random(400, 800);
            }
        }

        if (Dialogues.canContinue() && !Players.getLocal().isInCombat() && !Players.getLocal().isHealthBarVisible()) {
            log("Space to continue");
            Dialogues.spaceToContinue();
            return Calculations.random(400, 800);
        }


        if (state != State.CREATE_ACC) {
            List<WidgetChild> clickToContinue = Widgets.getWidgetChildrenContainingText("Click to continue");
            if (!clickToContinue.isEmpty()) {
                WidgetChild wc = clickToContinue.get(0);
                if (wc != null && wc.isVisible()) {
                    wc.interact();
                    sleep(900, 1200);
                }
            }
        }
        switch (state) {
            case CREATE_ACC:
                if (!Client.isLoggedIn()) {
                    int res = makeAccount();
                    if (res == -1) {
                        return res;
                    }
                } else {
                    accMade = true;
                    t = new Timer();
                    log("appearance");
                    final Widget par = Widgets.getWidget(APPEAR_PAR);
                    if (par != null && par.isVisible()) {
                        for (int i = 0; i < appChildren.length; i++) {
                            if (Client.seededRandom() >= 1) {
                                if (Client.seededRandom() > 1) {
                                    for (int ii = 0; ii < 5; ii++) {
                                        par.getChild(appChildren[i][0]).interact();
                                        sleep(100, 150);
                                    }
                                } else {
                                    for (int ii = 0; ii < 5; ii++) {
                                        par.getChild(appChildren[i][1]).interact();
                                        sleep(100, 150);
                                    }
                                }
                                sleep(200, 300);
                            }
                        }
                        par.getChild(ACCEPT).interact();
                        Sleep.sleepUntil(new Condition() {
                            public boolean verify() {
                                WidgetChild wc = par.getChild(ACCEPT);
                                return wc == null || !wc.isVisible();
                            }
                        }, 1200);
                        started = true;
                    }
                }
                break;
            case DO_TUT:

                //Detect what tutorial we are in
                if (this.inNewTutorial()) {
                    conf = PlayerSettings.getConfig(TUT_PROG_NEW);
                } else {
                    conf = PlayerSettings.getConfig(TUT_PROG);
                }

                if (Widgets.getWidget(162) != null && Widgets.getWidget(162).isVisible() && Widgets.getWidget(162).getChild(45) != null && Widgets.getWidget(162).getChild(45).isVisible()) {
                    log("Dialogue covering progress, clearing");
//                    Widgets.getWidget(162).getChild(45).interact();
                    Keyboard.type(" ");

                    Sleep.sleepUntil(() -> !Widgets.getWidget(162).isVisible(), 400);
                    return 0;
                }


                log("conf " + conf);


                //Scroll to exact value if we can
//                if (conf == 2 && ClientSettings.isResizableActive() && ClientSettings.getExactZoomValue() != 512) {
//                    log("Zooming into good zoom level");
//                    Mouse.scrollWhile(true, 200, () -> ClientSettings.getExactZoomValue() != 512);
//                    return 0;
//                }

                if (conf > 3 && ClientSettings.isResizableActive()) {
                    log("Enabling Resizable mode solver");
                    getRandomManager().enableSolver(RandomEvent.RESIZABLE_DISABLER);
                    return 0;
                }

//                //Enable the roof disabler
//                if (conf > 3 && !ClientSettings.roofsEnabled()) {
//                    log("Enabling roof disabler");
//                    getRandomManager().enableSolver(RandomEvent.ROOF_DISABLER);
//                    return 0;
//                }


                switch (conf) {
                    case 0:
                    case 1:

                        //663
                        Widget oldNameWidget = Widgets.getWidget(663);
                        if (oldNameWidget != null && oldNameWidget.isVisible()) {
                            log("Setting name");

                            //Look up name
                            oldNameWidget.getChild(17).interact();

                            log("Thinking of new name");
                            sleep(2000, 3000);
                            String name = rn.NewName();

                            log("Setting Name: " + name);
                            Keyboard.type(name, true, true);
                            Sleep.sleepUntil(() -> oldNameWidget.getChild(11).getText().equals(name) && oldNameWidget.getChild(12).getText().equals("Great! This display name is <col=00ff00>available</col>!"), 6000);

                            oldNameWidget.getChild(18).interact();
                            Sleep.sleepUntil(() -> !oldNameWidget.isVisible(), 10000);
                            break;
                        }

                        //Set name
                        Widget nameWidget = Widgets.getWidget(558);
                        if (nameWidget != null && nameWidget.isVisible()) {
                            log("Setting name");

                            //Look up name
                            nameWidget.getChild(17).interact();

                            log("Thinking of new name");
                            sleep(2000, 3000);
                            String name = new RandomName().NewName();

                            log("Setting Name: " + name);
                            Keyboard.type(name, true, true);
                            Sleep.sleepUntil(() -> nameWidget.getChild(11).getText().equals(name) && nameWidget.getChild(12).getText().equals("Great! This display name is <col=00ff00>available</col>!"), 6000);

                            nameWidget.getChild(18).interact();
                            Sleep.sleepUntil(() -> !nameWidget.isVisible(), 5000);
                            break;
                        }

                        if (Widgets.getWidget(269) != null && Widgets.getWidget(269).isVisible()) {
                            this.setApperance();
//                            sleep(1000, 2000);
                            break;
                        }

                        NPCs.closest(RUNESCAPE_GUIDE).interact();
                        break;
                  //  case 7:
                    case 2:
                        //Adjust camera, should help with misclicks
                        if (Camera.getPitch() < 250) {
                            Camera.rotateToPitch(Calculations.random(250, 300));
                        }

                        NPCs.closest(RUNESCAPE_GUIDE).interact();

                        break;
                    case 3:
                        if (ClientSettings.isResizableActive() || !ClientSettings.isZoomingEnabled()) {
                            log("Manual resizeable mode attempt");
                            if (ClientSettings.isResizableActive()) {
                                //turn off resizable
                                Mouse.move(new Rectangle(666, 469, 30, 40));
                                sleep(200, 500);
                                Mouse.click();
                                Sleep.sleepUntil(() -> !ClientSettings.isResizableActive(), Calculations.random(2000, 3000));
                                sleep(200, 500);
                            } else if (!ClientSettings.isZoomingEnabled()) {
                                //set default zoom
                                ClientSettings.setDefaultZoom();
                                sleep(900, 1200);
                            }
                            return Calculations.random(200, 500);
                        }

                        //open settings
                        break;
                    case 10:
                        if (!Walking.isRunEnabled()) {
                            Walking.toggleRun();
                        }
                        GameObject door = GameObjects.closest("Door");
                        if (door != null) {
                            if (door.interact("Open")) {
                                walkingSleep();
                                Sleep.sleepUntil(new Condition() {
                                    public boolean verify() {
                                        return PlayerSettings.getConfig(TUT_PROG) != 10;
                                    }
                                }, Calculations.random(1600, 2000));
                            }
                        }
                        //open door
                        break;
                    case 60:
                    case 20:
                        talkTo(SURVIVAL_EXPERT);
                        //talked to survival expert
                        break;
                    case 30:

                        if (!Tabs.isOpen(Tab.INVENTORY)) {
                            Tabs.openWithMouse(Tab.INVENTORY);
                            sleep(200, 600);
                        }

                        //opened invnetory
                        break;
                    case 40:
                        if (Players.getLocal().getAnimation() != -1) {
                            Sleep.sleepUntil(new Condition() {
                                public boolean verify() {
                                    return PlayerSettings.getConfig(TUT_PROG) != 80;
                                }
                            }, 5000);
                            break;
                        }
                        NPC pool = NPCs.closest("Fishing spot");
                        if (pool != null) {
                            if (pool.interact("Net")) {
                                walkingSleep();
                                Sleep.sleepUntil(new Condition() {
                                    public boolean verify() {
                                        return PlayerSettings.getConfig(TUT_PROG) != 80;
                                    }
                                }, Calculations.random(4000, 5000));
                            }
                        }
                        //caught shrimp
                        break;
                    case 50:
                        //opened skills
                        log("opening skills tab");
                        Tabs.openWithMouse(Tab.SKILLS);
                        Sleep.sleepUntil(() -> Tabs.isOpen(Tab.SKILLS), 600);
                        break;
                    case 70:
                        chopClosestTree();
                        sleep(600, 1200);
                        //chopped logs
                        break;
                    case 80:
                        boolean useableFire = GameObjects.closest("Fire") != null && GameObjects.closest("Fire").distance(Players.getLocal().getTile()) > 2;
                        if (!Inventory.contains("Logs") && useableFire) {
                            Sleep.sleepUntil(new Condition() {
                                public boolean verify() {
                                    return PlayerSettings.getConfig(TUT_PROG) != 50;
                                }
                            }, 1000);

                            chopClosestTree();

                            break;
                        }
                        lightFire();
                        //lit logs
                        break;
                    case 90:
                    case 100:
                        cookShrimp();
                        //burned shrimp
                        break;
                    case 110:
                        if (!Inventory.contains("Raw shrimps")) {
                            if (Players.getLocal().getAnimation() != -1) {
                                Sleep.sleepUntil(new Condition() {
                                    public boolean verify() {
                                        return Inventory.contains("Raw shrimps");
                                    }
                                }, 5000);
                            } else {
                                pool = NPCs.closest("Fishing spot");
                                if (pool != null) {
                                    pool.interact("Net");
                                    Sleep.sleepUntil(new Condition() {
                                        public boolean verify() {
                                            return Inventory.contains("Raw shrimps");
                                        }
                                    }, 5000);
                                }
                            }
                        } else {
                            cookShrimp();
                        }
                        //cooked second shrimp
                        break;
                    case 120:
                        Tile gateTile = new Tile(3091, 3092, 0);
                        if (inNewTutorial()) {
                            gateTile = new Tile(1683, 6100, 0);
                        }

                        if (Players.getLocal().getTile().distance(gateTile) > 5) {

                            Walking.walk(gateTile);
                            walkingSleep();
                        } else {
                            GameObject gate = GameObjects.closest("Gate");
                            if (gate != null) {
                                if (gate.interact("Open")) {
                                    walkingSleep();
                                    Sleep.sleepUntil(new Condition() {
                                        public boolean verify() {
                                            return PlayerSettings.getConfig(TUT_PROG) != 120;
                                        }
                                    }, Calculations.random(1400, 1800));
                                }
                            }
                        }
                        //went through gate
                        break;
                    case 130:
                        Tile doorTile = new Tile(3080, 3084, 0);
                        if (inNewTutorial()) {
                            doorTile = new Tile(1671, 6092, 0);
                        }

                        if (Players.getLocal().getTile().distance(doorTile) > 5) {
                            Walking.walk(doorTile);
                            walkingSleep();
                        } else {
                            GameObject gate = GameObjects.closest("Door");
                            if (gate != null) {
                                if (gate.interact("Open")) {
                                    walkingSleep();
                                    Sleep.sleepUntil(new Condition() {
                                        public boolean verify() {
                                            return PlayerSettings.getConfig(TUT_PROG) != 130;
                                        }
                                    }, 1200);
                                }
                            }
                        }
                        //went through cook door
                        break;
                    case 140:
                        if (inNewTutorial()) {
                            talkTo(MASTER_NAVIGATOR);
                        } else {
                            talkTo(COOK_GUIDE);
                        }
                        //talked to cook
                        break;

                    case 145:
                        if (!inNewTutorial())
                            break;

                        if (Widgets.getWidget(160) != null) {
                            log("Opening world map");
                            Widgets.getWidget(160).getChild(46).interact();

                            Sleep.sleepUntil(() -> Widgets.getWidget(595) != null && Widgets.getWidget(595).isVisible(), 2000);

                            sleep(1200, 4000); //Have a look at the map

                            log("Closing world map");
                            Widgets.getWidget(160).getChild(46).interact();
                            Sleep.sleepUntil(() -> Widgets.getWidget(595) == null, 2000);
                        }

                        break;
                    case 150:
                        if (inNewTutorial()) {
                            talkTo(MASTER_NAVIGATOR);
                            break;
                        }

                        if (!Inventory.isItemSelected()) {
                            if (Inventory.interact("Bucket of water", "Use")) {
                                Sleep.sleepUntil(new Condition() {
                                    public boolean verify() {
                                        return Inventory.isItemSelected();
                                    }
                                }, Calculations.random(1200, 1400));
                            }
                        } else {
                            if (Inventory.interact("Pot of flour", "Use")) {
                                Sleep.sleepUntil(new Condition() {
                                    public boolean verify() {
                                        return Inventory.contains("Bread dough");
                                    }
                                }, Calculations.random(1200, 1400));
                            }
                        }
                        //made dough
                        break;
                    case 155:
                        if (inNewTutorial()) {
                            talkTo(MASTER_NAVIGATOR);
                            break;
                        }
                    case 160:
                    case 166:
                        if (inNewTutorial()) {
                            talkTo(MASTER_NAVIGATOR);
                            break;
                        }

                        if (!Inventory.isItemSelected()) {
                            if (Inventory.interact("Bread dough", "Use")) {
                                Sleep.sleepUntil(new Condition() {
                                    public boolean verify() {
                                        return Inventory.isItemSelected();
                                    }
                                }, Calculations.random(1200, 1400));
                            }
                        } else {
                            GameObject range = GameObjects.closest("Range");
                            if (range.interact("Use")) {
                                walkingSleep();
                                Sleep.sleepUntil(new Condition() {
                                    public boolean verify() {
                                        return Inventory.contains("Bread");
                                    }
                                }, Calculations.random(2000, 3000));
                            }
                        }
                        //cooked bread
                        break;
                    case 170:
                    case 180:
                        Tile doorExitTile = new Tile(3073, 3090, 0);
                        if (inNewTutorial()) {
                            doorExitTile = new Tile(1665, 6098, 0);
                        }

                        if (Players.getLocal().getTile().distance(doorExitTile) > 5) {
                            Walking.walk(doorExitTile);
                            walkingSleep();
                        } else {
                            GameObject gate = GameObjects.closest("Door");
                            if (gate != null) {
                                if (gate.interact("Open")) {
                                    walkingSleep();
                                    Sleep.sleepUntil(new Condition() {
                                        public boolean verify() {
                                            return PlayerSettings.getConfig(TUT_PROG) != 180;
                                        }
                                    }, Calculations.random(1200, 1600));
                                }
                            }
                        }
                        //opened cook door
                        break;
                    case 183:
                        //opened emotes
                        break;
                    case 200:
                        log("Toggling run");
                        Walking.toggleRun();
                        sleep(400, 600);

//                        Rectangle r = new Rectangle(558, 115, 15, 25);
////                        Rectangle r = new Rectangle(560, 213, 20, 40);
//                        Mouse.move(r);
//                        log("Clicking run rectangle");
//                        Mouse.click();
//                        Sleep.sleepUntil(new Condition() {
//                            public boolean verify() {
//                                return PlayerSettings.getConfig(TUT_PROG) != 210;
//                            }
//                        }, 5000);
                        //use emote
                        break;
                    case 190:
                        //opened settings
                        break;
                    case 205:
                        //261,65
                        WidgetChild wc = Widgets.getChildWidget(261, 63);
                        if (wc != null && wc.isVisible()) {
                            wc.interact();
                            Sleep.sleepUntil(new Condition() {
                                public boolean verify() {
                                    return Walking.isRunEnabled();
                                }
                            }, 1200);
                        }
                        //turned on run in settings
                        break;
                    case 164:
                    case 165:
                    case 167:
                    case 168:
                    case 169:
                    case 210:
                        Tile questDoorEnter = new Tile(3086, 3126, 0);
                        if (inNewTutorial()) {
                            questDoorEnter = new Tile(1678, 6134, 0);
                        }

                        if (Players.getLocal().getTile().distance(questDoorEnter) > 5) {
                            Walking.walk(questDoorEnter);//, Calculations.random(10,15));
                            Sleep.sleepUntil(new Condition() {
                                public boolean verify() {
                                    return Players.getLocal().isMoving();
                                }
                            }, 1200);
                            Sleep.sleepUntil(new Condition() {
                                public boolean verify() {
                                    Tile dest = Client.getDestination();
                                    return !Players.getLocal().isMoving() || dest == null || Players.getLocal().distance(dest) < 5;
                                }
                            }, Calculations.random(2600, 3000));
                        } else {
                            GameObject gate = GameObjects.closest("Door");
                            if (gate != null) {
                                if (gate.interact("Open")) {
                                    walkingSleep();
                                    Sleep.sleepUntil(new Condition() {
                                        public boolean verify() {
                                            return PlayerSettings.getConfig(TUT_PROG) != 210;
                                        }
                                    }, Calculations.random(1200, 1400));
                                }
                            }
                        }
                        //opened door
                        break;
//                    case 240:
                    case 230:
                        //open quest tab
                        if (!Tabs.isOpen(Tab.QUEST)) {
                            log("opening quest tab");
                            Tabs.openWithMouse(Tab.QUEST);
                        }
                        break;
                    case 220:
                    case 240:
                        talkTo(QUEST_GUIDE);
                        break;
                    //talked to quest guy
                    case 250:
                        GameObject gate = GameObjects.closest("Ladder");
                        if (gate != null) {
                            log("Climbing down ladder");
                            if (gate.interact("Climb-down")) {
                                walkingSleep();
                                Sleep.sleepUntil(new Condition() {
                                    public boolean verify() {
                                        return PlayerSettings.getConfig(TUT_PROG) != 250;
                                    }
                                }, Calculations.random(4000, 6000));
                            }
                        }
                        //TODO Still gets stuck on camera
                        Camera.rotateToPitch(Calculations.random(320, 400));
                        Sleep.sleepUntil(() -> Camera.getPitch() > 320, 500);

                        //climb down ladder
                        break;
                    case 330:
                    case 290:
                    case 260:
                        if (inNewTutorial()) {
                            doorExitTile = new Tile(1665, 6098, 0);
                            Tile closerToMiningTrainer = new Tile(1674, 12512, 0);
                            if (Players.getLocal().getTile().distance(closerToMiningTrainer) > 5) {
                                Walking.walk(closerToMiningTrainer);
                                walkingSleep();
                                break;
                            }
                        } else {
                            Tile closerToMiningTrainer = new Tile(3082, 9505, 0);
                            if (Players.getLocal().getTile().distance(closerToMiningTrainer) > 5) {
                                Walking.walk(closerToMiningTrainer);
                                walkingSleep();
                                break;
                            }
                        }

                        talkTo(MINING_GUIDE);
                        //talk to mining instructor
                        break;
                    case 270:
                        Tile tinRock = new Tile(3077, 9504, 0);
                        if (inNewTutorial()) {
                            tinRock = new Tile(1665, 6098, 0);
                        }

//                        GameObject tin = GameObjects.closest(37945);

//                        GameObject tin = GameObjects.closest(new Filter<GameObject>() {
//                            public boolean match(GameObject g) {
//                                if (g == null || g.getName() == null)
//                                    return false;
//                                if (!g.getName().equals("Rocks"))
//                                    return false;
//                                if (g.getTile().equals(tinRock))
//                                    return true;
//                                return false;
//                            }
//                        });
//                        if (tin != null) {
//                            if (tin.interact("Prospect")) {
//                                walkingSleep();
//                                Sleep.sleepUntil(new Condition() {
//                                    public boolean verify() {
//                                        return PlayerSettings.getConfig(TUT_PROG) != 270;
//                                    }
//                                }, Calculations.random(3000, 4000));
//                            }
//                        }
                        //inspect tin
                        break;
                    case 280:
                        GameObject ptin = GameObjects.closest(37945);

//                        tin = GameObjects.closest(new Filter<GameObject>() {
//                            public boolean match(GameObject g) {
//                                if (g == null || g.getName() == null)
//                                    return false;
//                                if (!g.getName().equals("Rocks"))
//                                    return false;
//                                if (g.getTile().equals(new Tile(3083, 9501, 0)))
//                                    return true;
//                                return false;
//                            }
//                        });
                        if (ptin != null) {
                            if (ptin.interact("Prospect")) {
                                Sleep.sleepUntil(new Condition() {
                                    public boolean verify() {
                                        return PlayerSettings.getConfig(TUT_PROG) != 280;
                                    }
                                }, Calculations.random(4000, 5000));
                            }
                        }
                        //inspect copper
                        break;
                    case 300:
                        int rocks = 10080;
                        if (inNewTutorial())
                            rocks = 37945;

//                        tin = GameObjects.closest(new Filter<GameObject>() {
//                            public boolean match(GameObject g) {
//                                if (g == null || g.getName() == null)
//                                    return false;
//                                if (!g.getName().equals("Rocks"))
//                                    return false;
//                                if (g.getTile().equals(new Tile(3077, 9504, 0)))
//                                    return true;
//                                return false;
//                            }
//                        });
                        GameObject tin = GameObjects.closest(rocks);
                        if (tin != null) {
                            if (tin.interact("Mine")) {
                                walkingSleep();
                                Sleep.sleepUntil(new Condition() {
                                    public boolean verify() {
                                        return PlayerSettings.getConfig(TUT_PROG) != 300;
                                    }
                                }, Calculations.random(2000, 3000));
                            }
                        }
                        //mine tin
                        break;
                    case 310:
                        rocks = 10079;
                        if (inNewTutorial())
                            rocks = 37944;


                        GameObject copper = GameObjects.closest(rocks);
//                        tin = GameObjects.closest(new Filter<GameObject>() {
//                            public boolean match(GameObject g) {
//                                if (g == null || g.getName() == null)
//                                    return false;
//                                if (!g.getName().equals("Rocks"))
//                                    return false;
//                                if (g.getTile().equals(new Tile(3083, 9501, 0)))
//                                    return true;
//                                return false;
//                            }
//                        });
                        if (copper != null) {
                            if (copper.interact("Mine")) {
                                walkingSleep();
                                Sleep.sleepUntil(new Condition() {
                                    public boolean verify() {
                                        return PlayerSettings.getConfig(TUT_PROG) != 310;
                                    }
                                }, Calculations.random(2000, 3000));
                            }
                        }
                        //mine copper
                        break;
                    case 320:
                        if (!Inventory.isItemSelected()) {
                            sleep(1200, 1800);
                            Inventory.interact("Tin ore", "Use");
                            Sleep.sleepUntil(new Condition() {
                                public boolean verify() {
                                    return Inventory.isItemSelected();
                                }
                            }, Calculations.random(800, 1200));
                        } else if (Widgets.getWidget(270) != null && Widgets.getWidget(270).isVisible()) {
                            Widgets.getWidget(270).getChild(14).interact("Smelt");
                            Sleep.sleepUntil(new Condition() {
                                public boolean verify() {
                                    return Inventory.contains("Bronze bar");
                                }
                            }, Calculations.random(2000, 3000));
                        } else {
                            GameObject furnace = GameObjects.closest(10082);
                            if (inNewTutorial()) {
                                furnace = GameObjects.closest(37947);
                            }

                            if (furnace != null) {
                                if (furnace.interact("Use")) {
                                    walkingSleep();
                                    Sleep.sleepUntil(new Condition() {
                                        public boolean verify() {
                                            return Inventory.contains("Bronze bar");
                                        }
                                    }, Calculations.random(2000, 3000));
                                }
                            }
                        }
                        //smelt bronze
                        break;
                    case 340:
                        if (!Inventory.isItemSelected()) {
                            Inventory.interact("Bronze bar", "Use");
                            Sleep.sleepUntil(new Condition() {
                                public boolean verify() {
                                    return Inventory.isItemSelected();
                                }
                            }, 1200);
                        } else {
                            GameObject furnace = GameObjects.closest("Anvil");
                            if (furnace != null) {
                                if (furnace.interact("Use")) {
                                    walkingSleep();
                                    Sleep.sleepUntil(new Condition() {
                                        public boolean verify() {
                                            return PlayerSettings.getConfig(TUT_PROG) != 340;
                                        }
                                    }, Calculations.random(2000, 3000));
                                }
                            }
                        }
                        if (Widgets.getChildWidget(312, 9) != null && Widgets.getChildWidget(312, 9).isVisible()) {
                            Widgets.getChildWidget(312, 9).interact();
                            Sleep.sleepUntil(new Condition() {
                                public boolean verify() {
                                    return PlayerSettings.getConfig(TUT_PROG) != 350;
                                }
                            }, 3000);
                            //smith knife
                        }

                        //open anvil panel
                        break;
                    case 350:
                        if (inNewTutorial()) {
                            Tile newUndergroundGate = new Tile(1686, 12510, 0);
                            if (Players.getLocal().getTile().distance(newUndergroundGate) > 5) {
                                Walking.walk(newUndergroundGate);
                                walkingSleep();
                            } else {
                                gate = GameObjects.closest("Gate");
                                if (gate != null) {
                                    if (gate.interact("Open")) {
                                        walkingSleep();
                                        Sleep.sleepUntil(new Condition() {
                                            public boolean verify() {
                                                return PlayerSettings.getConfig(TUT_PROG) != 360;
                                            }
                                        }, Calculations.random(1200, 1800));
                                    }
                                }
                            }
                            break;
                        }

                        Widgets.getChildWidget(312, 9).interact();
                        Sleep.sleepUntil(new Condition() {
                            public boolean verify() {
                                return PlayerSettings.getConfig(TUT_PROG) != 350;
                            }
                        }, 3000);
                        //smith knife
                        break;
                    case 360:
                        if (inNewTutorial()) {
                            talkTo(COMBAT_GUIDE);
                            break;
                        }

                        if (Players.getLocal().getTile().distance(new Tile(3094, 9502, 0)) > 5) {
                            Walking.walk(new Tile(3094, 9502, 0));
                            walkingSleep();
                        } else {
                            gate = GameObjects.closest("Gate");
                            if (gate != null) {
                                if (gate.interact("Open")) {
                                    walkingSleep();
                                    Sleep.sleepUntil(new Condition() {
                                        public boolean verify() {
                                            return PlayerSettings.getConfig(TUT_PROG) != 360;
                                        }
                                    }, Calculations.random(1200, 1800));
                                }
                            }
                        }
                        //open gate
                        break;
                    case 410:
                    case 370:
                        talkTo(COMBAT_GUIDE);
                        //tlak to combat instructor
                        break;
                    case 390:
                        //open equipment
                        if (!Tabs.isOpen(Tab.EQUIPMENT)) {
                            log("opening EQUIPMENT tab");
                            Tabs.openWithMouse(Tab.EQUIPMENT);
                        }
                        break;
                    case 400:
                        Widgets.getChildWidget(387, 1).interact();
                        Sleep.sleepUntil(new Condition() {
                            public boolean verify() {
                                return PlayerSettings.getConfig(TUT_PROG) != 400;
                            }
                        }, Calculations.random(1200, 1600));
                        //open equipment stats
                        break;
                    case 405:
                        if (Inventory.interact("Bronze dagger", "Equip")) {
                            Sleep.sleepUntil(new Condition() {
                                public boolean verify() {
                                    return PlayerSettings.getConfig(TUT_PROG) != 410;
                                }
                            }, Calculations.random(1200, 1600));
                        } else if (Inventory.interact("Bronze dagger", "Wield")) {
                            Sleep.sleepUntil(new Condition() {
                                public boolean verify() {
                                    return PlayerSettings.getConfig(TUT_PROG) != 410;
                                }
                            }, Calculations.random(1200, 1600));
                        }
                        Widgets.getChildWidget(84, 4).interact();
                        //equip dagger
                        break;
                    case 420:
                        Item i = Equipment.getItemInSlot(EquipmentSlot.WEAPON.getSlot());
                        if (i != null && (i.getName().contains("dagger") || i.getName().contains("axe"))) {
                            Equipment.unequip(EquipmentSlot.WEAPON);
                            Sleep.sleepUntil(new Condition() {
                                public boolean verify() {
                                    return Equipment.getItemInSlot(EquipmentSlot.WEAPON.getSlot()) == null;
                                }
                            }, Calculations.random(1200, 1600));
                        } else {
                            if (i != null) {
                                Inventory.interact("Wooden shield", "Wield");
                                Sleep.sleepUntil(new Condition() {
                                    public boolean verify() {
                                        return Equipment.getItemInSlot(EquipmentSlot.SHIELD.getSlot()) != null;
                                    }
                                }, Calculations.random(1200, 1600));
                            } else {
                                Inventory.interact("Bronze sword", "Wield");
                                Sleep.sleepUntil(new Condition() {
                                    public boolean verify() {
                                        return Equipment.getItemInSlot(EquipmentSlot.WEAPON.getSlot()) != null;
                                    }
                                }, Calculations.random(1200, 1600));
                            }
                        }
                        //unequip knife
                        //equip sword/shield
                        break;
                    case 430:
                        //open combat tab
                        //open equipment
                        if (!Tabs.isOpen(Tab.COMBAT)) {
                            log("opening COMBAT tab");
                            Tabs.openWithMouse(Tab.COMBAT);
                        }
                        break;
                    case 440:
                        Tile mouseCageGate = new Tile(3111, 9518, 0);
                        if (inNewTutorial()) {
                            mouseCageGate = new Tile(1704, 12526, 0);
                        }

                        if (Players.getLocal().getTile().distance(mouseCageGate) > 5) {
                            Walking.walk(mouseCageGate);
                            walkingSleep();
                        } else {
                            gate = GameObjects.closest("Gate");
                            if (gate != null) {
                                if (gate.interact("Open")) {
                                    walkingSleep();
                                    Sleep.sleepUntil(new Condition() {
                                        public boolean verify() {
                                            return PlayerSettings.getConfig(TUT_PROG) != 360;
                                        }
                                    }, Calculations.random(1200, 1600));
                                }
                            }
                        }
                        //open rat gate
                        break;
                    case 450:
                        if (Players.getLocal().isInCombat()) {
                            log("Player in combat");
                            Sleep.sleepUntil(() -> !Players.getLocal().isInCombat(), 600);
                            break;
                        }

                        attackRat();
                        //attack rat
                        break;
                    case 460:
                        Sleep.sleepUntil(new Condition() {
                            public boolean verify() {
                                return PlayerSettings.getConfig(TUT_PROG) != 460;
                            }
                        }, 2400);
                        //killed rat
                        break;
                    case 465:
                        if (Inventory.contains("Bones")) {
                            log("Bones in inventory");
                            break;
                        } else {
                            //TODO Go back to rats and get some bones
                        }

                        GroundItem bones = GroundItems.closest("Bones");
                        if (bones == null) {
                            break;
                        }
                        bones.interact("Take");

                        Sleep.sleepUntil(new Condition() {
                            public boolean verify() {
                                return PlayerSettings.getConfig(TUT_PROG) != 465;
                            }
                        }, 2400);

                        //looted bones
                    case 470:
                        if (!Inventory.contains("Bones")) {
                            log("Missing bones in inventory");

                            bones = GroundItems.closest("Bones");
                            if (bones == null && !Players.getLocal().isInCombat()) {
                                //Kill new rat for bones
                                attackRat();
                                break;
                            }

                            log("Picking up bones");
                            bones.interact("Take");
                            Sleep.sleepUntil(() -> Inventory.contains("Bones"), 3000);
                            break;
                        }


                        mouseCageGate = new Tile(3111, 9518, 0);
                        if (inNewTutorial()) {
                            mouseCageGate = new Tile(1704, 12526, 0);
                        }

                        //TODO handle in cage better

                        if (!Map.canReach(mouseCageGate)) {
                            gate = GameObjects.closest("Gate");
                            if (gate != null) {
                                if (gate.distance(Players.getLocal().getTile()) > 7) {
                                    log("Walking closer to gate");
                                    Walking.walk(gate.getTile());
                                    walkingSleep();
                                }


                                if (gate.interact("Open")) {
                                    walkingSleep();
                                    Sleep.sleepUntil(new Condition() {
                                        public boolean verify() {
                                            return Players.getLocal().getTile().getX() == 3111;
                                        }
                                    }, Calculations.random(1200, 1400));
                                }
                            }
                        } else
                            talkTo(COMBAT_GUIDE);
                        //talk to combat instructor
                        break;
                    case 480:
                        if (Equipment.isSlotEmpty(EquipmentSlot.ARROWS.getSlot())) {
                            Inventory.interact("Bronze arrow", "Wield");
                            Sleep.sleepUntil(new Condition() {
                                public boolean verify() {
                                    return Equipment.isSlotFull(EquipmentSlot.ARROWS.getSlot());
                                }
                            }, Calculations.random(1200, 1600));
                        } else if (Inventory.contains("Shortbow")) {
                            Inventory.interact("Shortbow", "Wield");
                            Sleep.sleepUntil(new Condition() {
                                public boolean verify() {
                                    return !Inventory.contains("Shortbow");
                                }
                            }, Calculations.random(1200, 1600));
                        } else {
                            attackRat();
                        }
                        //equip bow & arrow
                        //attack rat
                        break;
                    case 490:
                        if (Equipment.isSlotEmpty(EquipmentSlot.ARROWS.getSlot())) {
                            Inventory.interact("Bronze arrow", "Wield");
                            Sleep.sleepUntil(new Condition() {
                                public boolean verify() {
                                    return Equipment.isSlotFull(EquipmentSlot.ARROWS.getSlot());
                                }
                            }, 1200);
                        } else if (Inventory.contains("Shortbow")) {
                            Inventory.interact("Shortbow", "Wield");
                            Sleep.sleepUntil(new Condition() {
                                public boolean verify() {
                                    return !Inventory.contains("Shortbow");
                                }
                            }, 1200);
                        } else {
                            if (Players.getLocal().getInteractingCharacter() == null) {
                                attackRat();
                            } else {
                                Sleep.sleepUntil(new Condition() {
                                    public boolean verify() {
                                        return PlayerSettings.getConfig(TUT_PROG) != 490;
                                    }
                                }, Calculations.random(2400, 3000));
                            }
                        }

                        //killed rat
                        break;
                    case 500:
                        Tile ladderUpTile = new Tile(3112, 9525, 0);
                        if (inNewTutorial()) {
                            ladderUpTile = new Tile(1703, 12533, 0);
                        }

                        if (Players.getLocal().getTile().distance(ladderUpTile) > 5) {
                            if (inNewTutorial()) {
                                Walking.walk(ladderUpTile);
                            } else {
                                Walking.walk(combatToLadder[combatToLadder.length - 1]);//, Calculations.random(10,15));
                            }
                            walkingSleep();
                        } else {
                            gate = GameObjects.closest("Ladder");
                            if (gate != null) {
                                if (gate.interact("Climb-up")) {
                                    walkingSleep();
                                    Sleep.sleepUntil(new Condition() {
                                        public boolean verify() {
                                            return PlayerSettings.getConfig(TUT_PROG) != 500;
                                        }
                                    }, Calculations.random(2400, 3600));
                                }
                            }
                        }
                        //go up ladder
                        break;
                    case 510:
                        if (inNewTutorial()) {
                            walkToPrayer();
                            break;
                        }

                        talkToBanker();
                        //use bank booth
                        //continue through convo
                        break;
                    case 520:
                        if (inNewTutorial()) {
                            openPrayerTab();
                            break;
                        }

                        usePollBooth();
                        //use poll booth
                        //continue through convo
                        //close poll booth
                        break;
                    case 525:
                        if (inNewTutorial()) {
                            openPrayerTab();
                            break;
                        }

                        usePollBooth();

                        door = GameObjects.closest(new Filter<GameObject>() {
                            public boolean match(GameObject g) {
                                if (g == null || g.getName() == null)
                                    return false;
                                if (!g.getName().equals("Door"))
                                    return false;
                                return g.getTile().equals(new Tile(3125, 3124, 0));
                            }
                        });
                        if (door != null) {
                            if (door.interact("Open")) {
                                walkingSleep();
                                Sleep.sleepUntil(new Condition() {
                                    public boolean verify() {
                                        return PlayerSettings.getConfig(TUT_PROG) != 525;
                                    }
                                }, Calculations.random(1600, 2400));
                            }
                        }
                        //go through door

                        break;
                    case 530:
                        if (inNewTutorial()) {
                            turnOnThickSkin();
                            break;
                        }

                        //talk to financial guy
                        talkTo(FINANCIAL_GUIDE);
                        sleep(600, 800);
                        break;

                    case 531:
                    case 532:

                        //quickly moves to logout tab briefly
                        if (!Tabs.isOpen(Tab.LOGOUT) && !Tabs.isOpen(Tab.ACCOUNT_MANAGEMENT)) {
                            log("opening ACCOUNT_MANAGEMENT tab");
                            Tabs.openWithMouse(Tab.ACCOUNT_MANAGEMENT);
                            Sleep.sleepUntil(() -> Tabs.isOpen(Tab.ACCOUNT_MANAGEMENT), 600);
                            break;
                        }

                        if (Dialogues.canContinue()) {
                            log("InDialog - Space to continue");
                            Dialogues.spaceToContinue();
                            return Calculations.random(400, 800);
                        }

//                        //open ACCOUNT_MANAGEMENT tab
//                        if (!Tabs.isOpen(Tab.ACCOUNT_MANAGEMENT)) { //TODO this is glitchy as it flashes
//                            log("opening ACCOUNT_MANAGEMENT tab");
//                            Tabs.openWithMouse(Tab.ACCOUNT_MANAGEMENT);
//                        }

                        //talk to financial guy
                        talkTo(FINANCIAL_GUIDE);
                        break;
                    case 535:
                        openPrayerTab();
                        break;
                    case 540:
                        if (inNewTutorial()) {
                            buryBones();
                            break;
                        }

                        openBankDoor();
                        //go through door
                        break;
                    case 545:
                        talkTo(PRAY_GUIDE);
                        break;
                    case 550:
                        if (inNewTutorial()) {
                            openFriendsTab();
                            break;
                        }

                        if (Players.getLocal().getTile().distance(new Tile(3126, 3106, 0)) > 5) {
                            Walking.walk(finToPray[finToPray.length - 1]);//, Calculations.random(10,15));
                            walkingSleep();
                        } else {
                            gate = GameObjects.closest(new Filter<GameObject>() {
                                public boolean match(GameObject g) {
                                    if (g == null || g.getName() == null) {
                                        return false;
                                    }
                                    if (!g.getName().equals("Large door"))
                                        return false;
                                    return g.getTile().equals(new Tile(3129, 3107, 0));
                                }
                            });
                            if (gate != null && !Map.canReach(NPCs.closest(PRAY_GUIDE).getTile())) {
                                if (gate.interact("Open")) {
                                    sleep(600, 900);
                                }
                            }
                            talkTo(PRAY_GUIDE);
                        }
                        //3128,3107
                        //check if double doors closed
                        //talk to prayer guy
                        break;
                    case 555:
                        openFriendsTab();
                        break;
                    case 560:
                        if (inNewTutorial()) {
                            openLargeDoor();
                            break;
                        }

                        openPrayerTab();
                        break;
                    case 565:
                        talkToBanker();
                        break;
                    //run to bank
                    case 600:
                    case 570:
                        if (inNewTutorial()) {
                            usePollBooth();
                            break;
                        }

                        talkTo(PRAY_GUIDE);
                        //talk to pray guy
                        break;
                    case 580:
                        if (inNewTutorial()) {
                            openBankDoor();
                            break;
                        }

                        openFriendsTab();
                        break;
                    case 590:
                        //open ignore
                        break;
                    case 610:
                        openLargeDoor();
                        //open door
                        break;
                    case 620:
                        walkToWizard();
                        //talkt o mage guy
                        break;
                    case 630:
                        //open magic tab
                        if (!Tabs.isOpen(Tab.MAGIC)) {
                            log("opening MAGIC tab");
                            Tabs.openWithMouse(Tab.MAGIC);
                        }
                        break;
                    case 640:
                        talkTo(MAGIC_GUIDE);
                        //talk to mage guy
                        break;
                    case 650:
                        killChicken();
                        //click spell
                        //click chicken
                        break;
                    case 670:
                        if (Dialogues.getOptions() != null) {
                            if (!inNewTutorial() && Dialogues.getOptions().length == 2)
                                Dialogues.clickOption(1);
                            else
                                Dialogues.clickOption(3);
                            break;
                        }

                        talkTo(MAGIC_GUIDE);
                        break;
                    case 680:
                        //Home teleport
                        homeTeleport();
                        break;

                    case 1000:
                        log("You're done!");
                        log("Finished in: " + this.t.formatTime());

                        sleep(1000, 5000);
                        Tabs.logout();

                        return -1;
                }
                break;
            case OPEN_TAB:
                log("OPEN_TAB");
                final Tab t = getTab();
                if (t == null) {
                    log("Tab is null?");
                    break;
                }
                if (Tabs.openWithMouse(t)) {
                    Sleep.sleepUntil(new Condition() {
                        public boolean verify() {
                            return Tabs.isOpen(t);
                        }
                    }, Calculations.random(1200, 1600));
                }
                break;
        }
        return Calculations.random(200, 300);
    }

    private void openLargeDoor() {
        GameObject door = GameObjects.closest("Door");
        if (door != null) {
            if (door.interact("Open")) {
                walkingSleep();
                Sleep.sleepUntil(new Condition() {
                    public boolean verify() {
                        return PlayerSettings.getConfig(TUT_PROG) != (inNewTutorial() ? 560 : 610);
                    }
                }, Calculations.random(1600, 2400));
            }
        }
    }

    private void openBankDoor() {
        Tile doorTile;
        Tile previousDoorTile = new Tile(3125, 3124, 0);

        if (inNewTutorial()) {
            doorTile = new Tile(1722, 6132, 0);

            if (Players.getLocal().distance(doorTile) > 2) {
                Walking.walk(doorTile);
                walkingSleep();
                return;
            }
        } else {
            doorTile = new Tile(3130, 3124, 0);

            if (Players.getLocal().getTile().distance(doorTile) < Players.getLocal().getTile().distance(previousDoorTile) &&
                    GameObjects.getTopObjectOnTile(previousDoorTile) != null && GameObjects.getTopObjectOnTile(previousDoorTile).hasAction("Open")) {
                log("First door closed, opening");
                GameObjects.getTopObjectOnTile(previousDoorTile).interact("Open");
                sleep(Calculations.random(1600, 2400));
                return;
            }
        }

        GameObject doorObject = GameObjects.getTopObjectOnTile(doorTile);
        if (doorObject != null && doorObject.interact("Open")) {
            walkingSleep();
            Sleep.sleepUntil(new Condition() {
                public boolean verify() {
                    return PlayerSettings.getConfig(TUT_PROG) != 540;
                }
            }, Calculations.random(1600, 2400));
        }
    }

    private void openTab(Tab t) {
        if (Tabs.openWithMouse(t)) {
            Sleep.sleepUntil(new Condition() {
                public boolean verify() {
                    return Tabs.isOpen(t);
                }
            }, Calculations.random(1200, 1600));
        }
    }

    private boolean attackRat() {
        NPC rat = NPCs.closest(new Filter<NPC>() {
            public boolean match(NPC n) {
                if (n == null || n.getName() == null)
                    return false;
                return n.getName().equals("Giant rat") && !n.isInCombat();
            }
        });
        if (rat != null) {
            if (rat.interact("Attack")) {
                walkingSleep();
                Sleep.sleepUntil(new Condition() {
                    public boolean verify() {
                        return PlayerSettings.getConfig(TUT_PROG) != 450;
                    }
                }, Calculations.random(1200, 2000));
                return true;
            } else {
                if (Camera.getPitch() < Calculations.random(150, 200)) {
                    Camera.rotateToPitch(Calculations.random(200, 360));
                }
            }
        }

        return false;
    }

    private void talkToBanker() {
        Tile bankTile;
        if (inNewTutorial()) {
            bankTile = new Tile(1713, 6129, 0);
        } else {
            bankTile = new Tile(3122, 3123, 0);
        }

        if (Players.getLocal().distance(bankTile) > 5) {
            Walking.walk(bankTile);
            walkingSleep();
        } else {
            if (Dialogues.getOptionIndex("Yes.") > 0) {
                Dialogues.clickOption("Yes.");
                Sleep.sleepUntil(new Condition() {
                    public boolean verify() {
                        return Bank.isOpen();
                    }
                }, Calculations.random(1200, 1600));

                Bank.depositAllItems();
                Sleep.sleepUntil(new Condition() {
                    public boolean verify() {
                        return Inventory.isEmpty();
                    }
                }, Calculations.random(800, 1200));

                Bank.depositAllEquipment();
                Sleep.sleepUntil(new Condition() {
                    public boolean verify() {
                        return Equipment.isEmpty();
                    }
                }, Calculations.random(800, 1200));

                Bank.close();
                Sleep.sleepUntil(new Condition() {
                    public boolean verify() {
                        return !Bank.isOpen();
                    }
                }, Calculations.random(800, 1200));
            } else {
                if (!Dialogues.canContinue()) {
                    GameObject bankBooth = GameObjects.closest("Bank booth");
                    if (bankBooth != null) {
                        if (bankBooth.interact("Use")) {
                            Sleep.sleepUntil(new Condition() {
                                public boolean verify() {
                                    return Dialogues.canContinue();
                                }
                            }, Calculations.random(2400, 3000));
                        }
                    }
                } else {
                    Dialogues.clickContinue();
                    Sleep.sleepUntil(new Condition() {
                        public boolean verify() {
                            return !Dialogues.canContinue();
                        }
                    }, Calculations.random(1200, 1400));
                }
            }

        }
    }

    private void usePollBooth() {
        if (Bank.isOpen()) {
            Bank.close();
            Sleep.sleepUntil(new Condition() {
                public boolean verify() {
                    return !Bank.isOpen();
                }
            }, Calculations.random(1200, 1600));
            return;
        }

        log("Poll Open config: " + PlayerSettings.getConfig(POLL_OPEN));

        //Old method open
        if (PlayerSettings.getConfig(POLL_OPEN) == 0) {
            GameObject pbooth = GameObjects.closest("Poll booth");
            if (pbooth != null) {
                if (pbooth.interact("Use")) {
                    walkingSleep();
                    Sleep.sleepUntil(new Condition() {
                        public boolean verify() {
                            return Dialogues.canContinue();
                        }
                    }, 2400);
                }
            }
            if (Dialogues.canContinue()) {
                while (Dialogues.canContinue() || PlayerSettings.getConfig(POLL_OPEN) == 0) {
                    Dialogues.spaceToContinue();
                    sleep(300, 500);
                }
            }
            log("Poll config: " + PlayerSettings.getConfig(POLL_OPEN));
            sleep(300, 500);
            return;
        }

        Widget pollWidget = Widgets.getWidget(345);
        log("Attempting new poll booth close");
        if (pollWidget != null && pollWidget.isVisible()) {
            if (closePollBooth())
                return;
        }

        //Close via old method
        if (PlayerSettings.getConfig(POLL_OPEN) > 65536) { //TODO hacky
            WidgetChild bar = Widgets.getChildWidget(310, 1);
            if (bar != null) {
                bar = bar.getChild(11);
            }
            if (bar != null && bar.isVisible()) {
                bar.interact();
                Sleep.sleepUntil(new Condition() {
                    public boolean verify() {
                        return PlayerSettings.getConfig(POLL_OPEN) == 0;
                    }
                }, Calculations.random(1200, 1500));
            }
            return;
        }

        GameObject pbooth = GameObjects.closest("Poll booth");
        if (pbooth != null) {
            if (pbooth.interact("Use")) {
                walkingSleep();
                Sleep.sleepUntil(new Condition() {
                    public boolean verify() {
                        return Dialogues.canContinue();
                    }
                }, 2400);
            }
        }
    }

    private boolean closePollBooth() {
        Widget pollWidget = Widgets.getWidget(345);
        if (pollWidget != null && pollWidget.isVisible()) {
            WidgetChild closeButton = pollWidget.getChild(2).getChild(11);
            if (closeButton == null) {
                log("Unable to find close button");
                return false;
            }

            log("Closing poll booth");
            closeButton.interact();
            Sleep.sleepUntil(() -> !pollWidget.isVisible(), 2000);
            return true;
        }
        return true;
    }

    private void homeTeleport() {
        Tile finalArea = new Tile(1733, 6096);
        Magic.castSpell(Normal.HOME_TELEPORT);
        Sleep.sleepUntil(() -> !finalArea.getArea(5).contains(Players.getLocal().getTile()), 15000);
    }

    private void killChicken() {
        Tile chickenTile;
        if (inNewTutorial()) {
            chickenTile = new Tile(1733, 6099, 0);

            if (tryOtherWizard) {
                chickenTile = new Tile(1727, 6121, 0);
            }
        } else {
            chickenTile = new Tile(3139, 3091, 0);
        }

        if (Players.getLocal().getTile().distance(chickenTile) > 2) {
            log("Walking closer to chicken");
            Walking.walk(chickenTile);
            walkingSleep();
            return;
        }

        Entity chicken = NPCs.closest("Chicken");
        if (chicken == null) {
            log("Unable to find chicken to case wind strike");
            return;
        }

        log("Casting wind strike on chicken");
        if (Magic.castSpellOn(Normal.WIND_STRIKE, chicken)) {
            Sleep.sleepUntil(new Condition() {
                public boolean verify() {
                    return PlayerSettings.getConfig(TUT_PROG) != 650;
                }
            }, Calculations.random(1600, 2400));
        }
    }

    private boolean tryOtherWizard = false;

    private void walkToWizard() {
        Tile wizardTile;
        //Random other wizard tile i think i have
        Tile otherWizardTile = new Tile(1727, 6121, 0);

        if (inNewTutorial()) {
            wizardTile = new Tile(1732, 6095, 0);
            if (tryOtherWizard) {
                log("Trying other wizard location");
                wizardTile = otherWizardTile;
            }

        } else {
            wizardTile = new Tile(3141, 3088, 0);
        }

        if (Players.getLocal().getTile().distance(wizardTile) > 5) {
            if (inNewTutorial()) {
                Walking.walk(wizardTile);
            } else {
                Walking.walk(prayToMage[prayToMage.length - 1]);//;,Calculations.random(10,15));
                walkingSleep();
            }
        } else {
            talkTo(MAGIC_GUIDE);
        }
    }

    private void walkToPrayer() {
        Tile prayerTile;
        if (inNewTutorial()) {
            prayerTile = new Tile(1714, 6115, 0);
        } else {
            prayerTile = new Tile(3122, 3123, 0);
        }

        if (Players.getLocal().distance(prayerTile) > 5) {
            Walking.walk(prayerTile);
            walkingSleep();
            return;
        }

        openPrayerTab(); //Start chat with dude
    }

    private void openPrayerTab() {
        //open pray tab
        log("opening PRAYER tab");
        Tabs.openWithMouse(Tab.PRAYER);
        Sleep.sleepUntil(() -> Tabs.isOpen(Tab.PRAYER), 400);

        talkTo(PRAY_GUIDE);
    }

    private void openFriendsTab() {
        //open friends
        log("opening FRIENDS tab");
        Tabs.openWithMouse(Tab.FRIENDS);
        Sleep.sleepUntil(() -> Tabs.isOpen(Tab.FRIENDS), 400);

        talkTo(PRAY_GUIDE);
    }

    private boolean prayedAtAltar = false;

    private void turnOnThickSkin() {
        //open pray tab
        if (!Tabs.isOpen(Tab.PRAYER)) {
            log("opening PRAYER tab");
            Tabs.openWithMouse(Tab.PRAYER);
            Sleep.sleepUntil(() -> Tabs.isOpen(Tab.PRAYER), 600);
            return;
        }

        if (Skills.getBoostedLevel(Skill.PRAYER) > 0 && !prayedAtAltar) {
            log("Turning on thick skin");
            if (!Prayers.isActive(Prayer.THICK_SKIN)) {
                Prayers.toggle(true, Prayer.THICK_SKIN);
                Sleep.sleepUntil(() -> Prayers.isActive(Prayer.THICK_SKIN), 800);
                return;
            }
            Sleep.sleepUntil(() -> Skills.getBoostedLevel(Skill.PRAYER) == 0, 3000);
            return;
        }

        if (Skills.getBoostedLevel(Skill.PRAYER) == 0) {
            log("Praying at altar");
            if (GameObjects.closest("Altar").interact("Pray-at"))
                prayedAtAltar = true;

            return;
        }

        talkTo(PRAY_GUIDE);
    }

    private void buryBones() {
        if (!Tabs.isOpen(Tab.INVENTORY)) {
            Tabs.openWithMouse(Tab.INVENTORY);
            Sleep.sleepUntil(() -> Tabs.isOpen(Tab.INVENTORY), 600);
        }

        if (Inventory.get("Bones") != null) {
            Inventory.get("Bones").interact("Bury");
            Sleep.sleepUntil(() -> Inventory.get("Bones") == null, 700);
        }
    }

    private void cookShrimp() {
        GameObject fire = GameObjects.closest("Fire");
        if (fire == null)
            lightFire();
        else {
            if (!Inventory.isItemSelected()) {
                if (Inventory.interact("Raw shrimps", "Use")) {
                    Sleep.sleepUntil(new Condition() {
                        public boolean verify() {
                            return Inventory.isItemSelected();
                        }
                    }, Calculations.random(800, 1200));
                }
            }
            if (Inventory.isItemSelected()) {
                if (fire.interact("Use")) {
                    walkingSleep();
                    Sleep.sleepUntil(new Condition() {
                        public boolean verify() {
                            return Players.getLocal().getAnimation() != -1;
                        }
                    }, Calculations.random(2000, 3000));
                    Sleep.sleepUntil(new Condition() {
                        public boolean verify() {
                            return Players.getLocal().getAnimation() == -1;
                        }
                    }, Calculations.random(2000, 3000));
                }
            }
        }
    }

    private void lightFire() {
        if (!Inventory.contains("Logs")) {
            GameObject tree = GameObjects.closest("Tree");
            if (tree != null) {
                if (tree.interact("Chop down")) {
                    walkingSleep();
                    Sleep.sleepUntil(new Condition() {
                        public boolean verify() {
                            return Inventory.contains("Logs");
                        }
                    }, Calculations.random(1200, 1600));
                }
                if (Players.getLocal().getAnimation() != -1) {
                    Sleep.sleepUntil(new Condition() {
                        public boolean verify() {
                            return Inventory.contains("Logs");
                        }
                    }, Calculations.random(4000, 5000));
                }
            }
        }

        if (GameObjects.getTopObjectOnTile(Players.getLocal().getTile()) != null && GameObjects.getTopObjectOnTile(Players.getLocal().getTile()).getName().equals("Fire")) {
            log("fire in the way, moving");
            if (inNewTutorial()) {
                Walking.walk(Players.getLocal().getTile().getArea(2).getRandomTile());
                walkingSleep();
                return;
            } else {
                //Avoid burning where the other bots do
                Area burnArea = new Area(new Tile(3104, 3098), new Tile(3106, 3100));
                Walking.walk(burnArea.getRandomTile());
                sleep(1000, 4000);
            }
        }


        if (Inventory.contains("Logs")) {
            if (!Inventory.isItemSelected()) {
                Inventory.interact("Tinderbox", "Use");
                Sleep.sleepUntil(new Condition() {
                    public boolean verify() {
                        return Inventory.isItemSelected();
                    }
                }, Calculations.random(800, 1200));
            }
            if (Inventory.isItemSelected()) {
                Inventory.interact("Logs", "Use");
                Sleep.sleepUntil(new Condition() {
                    public boolean verify() {
                        return Players.getLocal().getAnimation() != -1;
                    }
                }, Calculations.random(1200, 1600));
                Sleep.sleepUntil(new Condition() {
                    public boolean verify() {
                        return Players.getLocal().getAnimation() == -1;
                    }
                }, Calculations.random(6000, 8000));
            }
        }
    }

    private void talkTo(String npc) {

        log("Talking to: " + npc);
        List<WidgetChild> clickToContinue = Widgets.getWidgetChildrenContainingText("Click to continue");

        if (!clickToContinue.isEmpty()) {
            WidgetChild wc = clickToContinue.get(0);
            if (wc != null && wc.isVisible()) {
                log("Interacting with widget");
                wc.interact();
                sleep(900, 1200);
            }
            log("no widget interaction");
        }

        //If speaking to RS Guide, check for the option of experienced player
        if (Widgets.getWidget(219) != null && Widgets.getWidget(219).isVisible()) {
            if (Widgets.getWidget(219).getChild(1) != null && Widgets.getWidget(219).getChild(1).isVisible()) {
                WidgetChild[] widgetOptions = Widgets.getWidget(219).getChild(1).getChildren();

                for (int idx = 0; idx < widgetOptions.length; idx++) {
                    log("Option (" + idx + ") ='" + widgetOptions[idx].getText() + "'");

                    if (widgetOptions[idx].getText().equals("I am an experienced player.")) {
                        log("Option detected at idx: " + idx);
                        Keyboard.;
                        sleep(600, 1200);
                        break;
                    }

                    if (widgetOptions[idx].getText().equals("No, I'm not planning to do that.")) {
                        log("Option detected at idx: " + idx);
                        Keyboard.type(idx);
                        sleep(600, 1200);
                        break;
                    }
                }
            }
        }

        String[] options = Dialogues.getOptions();
        if (options != null) {
            log("Options detected: " + options.toString());
            for (int i = 0; i < options.length; i++) {
                log("Option (" + i + ") ='" + options[i] + "'");
            }
            Keyboard.type("1");
            sleep(600, 800);
        }

        if (Dialogues.canContinue()) {
            log("talkTo - Space continue");
            Dialogues.spaceToContinue();
            return;
        }

        final NPC guide = NPCs.closest(npc);
        log("finding npc " + guide);


        if (npc.equals(MAGIC_GUIDE) && guide == null) {
            log("Cant find wizard, trying other location");
            tryOtherWizard = true;
            return;
        }


        if (guide != null) {
            if (!ClientSettings.isResizableActive()) {
                if (guide.isOnScreen()) {
                    if (guide.interact("Talk-to")) {
                        walkingSleep();
                        Sleep.sleepUntil(new Condition() {
                            public boolean verify() {
                                return Dialogues.canContinue();
                            }
                        }, Calculations.random(1200, 1600));
                    }
                } else {
                    Walking.walk(guide);
                    walkingSleep();
                }
            } else {
                Point p = guide.getModel().calculateCenterPoint();
                p.setLocation(p.getX() * (CANVAS.getWidth() / GAME_SCREEN.getWidth()), p.getY() * (CANVAS.getHeight() / GAME_SCREEN.getHeight()));
                Mouse.hop(p);
                sleep(50, 80);
                Mouse.click(true);
                sleep(200, 400);
            }
        }

        if (Menu.isVisible()) {
            if (Menu.contains("Talk-to")) {
                Menu.clickAction("Talk-to");
                Sleep.sleepUntil(() -> Dialogues.canContinue(), Calculations.random(2000, 3000));
            } else {
                Menu.close();
                sleep(600, 900);
            }
        }
    }

    private int chopClosestTree() {
        GameObject tree = GameObjects.closest("Tree");
        if (tree != null) {
            if (Players.getLocal().getAnimation() != -1) {
                Sleep.sleepUntil(new Condition() {
                    public boolean verify() {
                        return Inventory.contains("Logs");
                    }
                }, Calculations.random(1000, 2000));
                return 0;
            }
            if (tree.interact("Chop down")) {
                walkingSleep();
                Sleep.sleepUntil(new Condition() {
                    public boolean verify() {
                        return Inventory.contains("Logs");
                    }
                }, Calculations.random(1000, 2000));
            }
        }
        log("Unable to find tree close to player");
        return 0;
    }

    private int setApperance() {
        Rectangle acceptBox = new Rectangle(246, 269, 50, 40);
        sleep(this.clickArea(acceptBox));
        return 0;
    }

    private int clickArea(Rectangle area) {
        Mouse.move(area);
        sleep(200, 500);
        Mouse.click();

        return Calculations.random(0, 600);
    }

    private Tab getTab() {
        int conf = PlayerSettings.getConfig(TAB_CONFIG);
        switch (conf) {
            case 1:
                return Tab.COMBAT;
            case 2:
                return Tab.SKILLS;
            case 3:
                return Tab.QUEST;
            case 4:
                return Tab.INVENTORY;
            case 5:
                return Tab.EQUIPMENT;
            case 6:
                return Tab.PRAYER;
            case 7:
               return Tab.MAGIC;
            case 8:
                return Tab.CLAN;
            case 10:
            case 9:
                return Tab.FRIENDS;
            case 11:
                return Tab.LOGOUT;
            case 12:
                return Tab.OPTIONS;
            case 13:
                return Tab.EMOTES;
            case 14:
                return Tab.MUSIC;
        }
        return null;
    }

    private void getCurrentStep() {
        int maj = PlayerSettings.getConfig(TUT_PROG_MAJOR);
        int min = PlayerSettings.getConfig(TUT_PROG_MINOR);

    }

    private void walkingSleep() {
        Sleep.sleepUntil(new Condition() {
            public boolean verify() {
                return Players.getLocal().isMoving();
            }
        }, Calculations.random(1200, 1600));
        Sleep.sleepUntil(new Condition() {
            public boolean verify() {
                return !Players.getLocal().isMoving();
            }
        }, Calculations.random(2400, 3600));
    }

    public void onPaint(Graphics g) {
        if (state != null) {
            g.drawString("State: " + state, 10, 40);
        }
        g.drawString("Current progress: " + (inNewTutorial() ? PlayerSettings.getConfig(TUT_PROG_NEW) : PlayerSettings.getConfig(TUT_PROG)), 10, 60);
        if (t != null)
            g.drawString("Runtime: " + t.formatTime(), 10, 80);

        g.drawString("inNewTutorial: " + this.inNewTutorial(), 10, 100);
       // g.drawString("exactZoomValue: " + ClientSettings.zoom, 10, 120);
    }

}