package com.wlw.leetcode1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.wlw.leetcode.util.ParamUtil;

public class Q126_WordLadderII {

	public static void main(String[] args) {
		Q126_WordLadderII test = new Q126_WordLadderII();
		
		String beginWord = "charge";
		String endWord = "comedo";
		String str = ""+/**~{*/""
			+ ""
+ "\r\n[\"shanny\",\"shinny\",\"whinny\",\"whiney\",\"shiver\",\"sharer\",\"scarer\",\"scaler\",\"render\",\"fluxes\",\"teases\""
+ "\r\n,\"starks\",\"clinks\",\"messrs\",\"crewed\",\"donner\",\"blurts\",\"bettye\",\"powell\",\"castes\",\"hackee\",\"hackle\""
+ "\r\n,\"heckle\",\"deckle\",\"decile\",\"defile\",\"define\",\"refine\",\"repine\",\"rapine\",\"ravine\",\"raving\",\"roving\""
+ "\r\n,\"chased\",\"roping\",\"coping\",\"coming\",\"homing\",\"pointy\",\"hominy\",\"homily\",\"homely\",\"comely\",\"comedy\""
+ "\r\n,\"comedo\",\"vagues\",\"crocus\",\"spiked\",\"bobbed\",\"dourer\",\"smells\",\"feared\",\"wooden\",\"stings\",\"loafer\""
+ "\r\n,\"pleads\",\"gaiter\",\"meeter\",\"denser\",\"bather\",\"deaves\",\"wetted\",\"pleats\",\"cadger\",\"curbed\",\"grover\""
+ "\r\n,\"hinged\",\"budget\",\"gables\",\"larked\",\"flunks\",\"fibbed\",\"bricks\",\"bowell\",\"yonder\",\"grimes\",\"clewed\""
+ "\r\n,\"triads\",\"legion\",\"lacier\",\"ridden\",\"bogied\",\"camper\",\"damien\",\"spokes\",\"flecks\",\"goosed\",\"snorer\""
+ "\r\n,\"choked\",\"choler\",\"leakey\",\"vagued\",\"flumes\",\"scanty\",\"bugger\",\"tablet\",\"nilled\",\"julies\",\"roomed\""
+ "\r\n,\"ridges\",\"snared\",\"singes\",\"slicks\",\"toiled\",\"verged\",\"shitty\",\"clicks\",\"farmed\",\"stunts\",\"dowsed\""
+ "\r\n,\"brisks\",\"skunks\",\"linens\",\"hammer\",\"naiver\",\"duster\",\"elates\",\"kooked\",\"whacky\",\"mather\",\"loomed\""
+ "\r\n,\"soured\",\"mosses\",\"keeled\",\"drains\",\"drafty\",\"cricks\",\"glower\",\"brayed\",\"jester\",\"mender\",\"burros\""
+ "\r\n,\"arises\",\"barker\",\"father\",\"creaks\",\"prayed\",\"bulges\",\"heaped\",\"called\",\"volley\",\"girted\",\"forded\""
+ "\r\n,\"huffed\",\"bergen\",\"grated\",\"douses\",\"jagger\",\"grovel\",\"lashes\",\"creeds\",\"bonier\",\"snacks\",\"powder\""
+ "\r\n,\"curled\",\"milker\",\"posers\",\"ribbed\",\"tracts\",\"stoked\",\"russel\",\"bummer\",\"cusses\",\"gouged\",\"nailed\""
+ "\r\n,\"lobbed\",\"novels\",\"stands\",\"caches\",\"swanks\",\"jutted\",\"zinged\",\"wigged\",\"lunges\",\"divers\",\"cranny\""
+ "\r\n,\"pinter\",\"guides\",\"tigers\",\"traces\",\"berber\",\"purges\",\"hoaxer\",\"either\",\"bribed\",\"camped\",\"funked\""
+ "\r\n,\"creaky\",\"noises\",\"paused\",\"splits\",\"morrow\",\"faults\",\"ladies\",\"dinged\",\"smoker\",\"calved\",\"deters\""
+ "\r\n,\"kicker\",\"wisher\",\"ballad\",\"filled\",\"fobbed\",\"tucker\",\"steams\",\"rubber\",\"staled\",\"chived\",\"warred\""
+ "\r\n,\"draped\",\"curfew\",\"chafed\",\"washer\",\"tombed\",\"basket\",\"limned\",\"rapped\",\"swills\",\"gashed\",\"loaner\""
+ "\r\n,\"settee\",\"layers\",\"bootee\",\"rioted\",\"prance\",\"sharps\",\"wigner\",\"ranted\",\"hanker\",\"leaden\",\"groped\""
+ "\r\n,\"dalian\",\"robbed\",\"peeled\",\"larder\",\"spoofs\",\"pushed\",\"hallie\",\"maiden\",\"waller\",\"pashas\",\"grains\""
+ "\r\n,\"pinked\",\"lodged\",\"zipper\",\"sneers\",\"bootie\",\"drives\",\"former\",\"deepen\",\"carboy\",\"snouts\",\"fained\""
+ "\r\n,\"wilmer\",\"trance\",\"bugles\",\"chimps\",\"deeper\",\"bolder\",\"cupped\",\"mauser\",\"pagers\",\"proven\",\"teaser\""
+ "\r\n,\"plucky\",\"curved\",\"shoots\",\"barged\",\"mantes\",\"reefer\",\"coater\",\"clotho\",\"wanner\",\"likens\",\"swamis\""
+ "\r\n,\"troyes\",\"breton\",\"fences\",\"pastas\",\"quirky\",\"boiler\",\"canoes\",\"looted\",\"caries\",\"stride\",\"adorns\""
+ "\r\n,\"dwells\",\"hatred\",\"cloths\",\"rotted\",\"spooks\",\"canyon\",\"lances\",\"denied\",\"beefed\",\"diaper\",\"wiener\""
+ "\r\n,\"rifled\",\"leader\",\"ousted\",\"sprays\",\"ridged\",\"mousey\",\"darken\",\"guiled\",\"gasses\",\"suited\",\"drools\""
+ "\r\n,\"bloody\",\"murals\",\"lassie\",\"babied\",\"fitter\",\"lessee\",\"chiles\",\"wrongs\",\"malian\",\"leaves\",\"redder\""
+ "\r\n,\"funnel\",\"broths\",\"gushes\",\"grants\",\"doyens\",\"simmer\",\"locked\",\"spoors\",\"berger\",\"landed\",\"mosley\""
+ "\r\n,\"scorns\",\"whiten\",\"hurled\",\"routed\",\"careen\",\"chorus\",\"chasms\",\"hopped\",\"cadged\",\"kicked\",\"slewed\""
+ "\r\n,\"shrewd\",\"mauled\",\"saucer\",\"jested\",\"shriek\",\"giblet\",\"gnarls\",\"foaled\",\"roughs\",\"copses\",\"sacked\""
+ "\r\n,\"blends\",\"slurps\",\"cashew\",\"grades\",\"cramps\",\"radius\",\"tamped\",\"truths\",\"cleans\",\"creams\",\"manner\""
+ "\r\n,\"crimps\",\"hauled\",\"cheery\",\"shells\",\"asters\",\"scalps\",\"quotas\",\"clears\",\"clover\",\"weeder\",\"homers\""
+ "\r\n,\"pelted\",\"hugged\",\"marked\",\"moaned\",\"steely\",\"jagged\",\"glades\",\"goshes\",\"masked\",\"ringer\",\"eloped\""
+ "\r\n,\"vortex\",\"gender\",\"spotty\",\"harken\",\"hasten\",\"smiths\",\"mulled\",\"specks\",\"smiles\",\"vainer\",\"patted\""
+ "\r\n,\"harden\",\"nicked\",\"dooley\",\"begged\",\"belief\",\"bushel\",\"rivers\",\"sealed\",\"neuter\",\"legged\",\"garter\""
+ "\r\n,\"freaks\",\"server\",\"crimea\",\"tossed\",\"wilted\",\"cheers\",\"slides\",\"cowley\",\"snotty\",\"willed\",\"bowled\""
+ "\r\n,\"tortes\",\"pranks\",\"yelped\",\"slaved\",\"silver\",\"swords\",\"miners\",\"fairer\",\"trills\",\"salted\",\"copsed\""
+ "\r\n,\"crusts\",\"hogged\",\"seemed\",\"revert\",\"gusted\",\"pixies\",\"tamika\",\"franks\",\"crowed\",\"rocked\",\"fisher\""
+ "\r\n,\"sheers\",\"pushes\",\"drifts\",\"scouts\",\"sables\",\"sallie\",\"shiner\",\"coupes\",\"napped\",\"drowse\",\"traced\""
+ "\r\n,\"scenes\",\"brakes\",\"steele\",\"beater\",\"buries\",\"turned\",\"luther\",\"bowers\",\"lofted\",\"blazer\",\"serves\""
+ "\r\n,\"cagney\",\"hansel\",\"talker\",\"warmed\",\"flirts\",\"braced\",\"yukked\",\"milken\",\"forged\",\"dodder\",\"strafe\""
+ "\r\n,\"blurbs\",\"snorts\",\"jetted\",\"picket\",\"pistil\",\"valved\",\"pewter\",\"crawls\",\"strews\",\"railed\",\"clunks\""
+ "\r\n,\"smiled\",\"dealer\",\"cussed\",\"hocked\",\"spited\",\"cowers\",\"strobe\",\"donned\",\"brawls\",\"minxes\",\"philby\""
+ "\r\n,\"gavels\",\"renter\",\"losses\",\"packet\",\"defied\",\"hazier\",\"twines\",\"balled\",\"gaoled\",\"esther\",\"narrow\""
+ "\r\n,\"soused\",\"crispy\",\"souped\",\"corned\",\"cooley\",\"rioter\",\"talley\",\"keaton\",\"rocker\",\"spades\",\"billie\""
+ "\r\n,\"mattel\",\"billet\",\"horton\",\"navels\",\"sander\",\"stoker\",\"winded\",\"wilder\",\"cloyed\",\"blazed\",\"itched\""
+ "\r\n,\"docked\",\"greene\",\"boozed\",\"ticket\",\"temped\",\"capons\",\"bravos\",\"rinded\",\"brandi\",\"massed\",\"sobbed\""
+ "\r\n,\"shapes\",\"yippee\",\"script\",\"lesion\",\"mallet\",\"seabed\",\"medals\",\"series\",\"phases\",\"grower\",\"vertex\""
+ "\r\n,\"dented\",\"tushed\",\"barron\",\"toffee\",\"bushes\",\"mouser\",\"zenger\",\"quaked\",\"marley\",\"surfed\",\"harmed\""
+ "\r\n,\"mormon\",\"flints\",\"shamed\",\"forgot\",\"jailor\",\"boater\",\"sparer\",\"shards\",\"master\",\"pistol\",\"tooted\""
+ "\r\n,\"banned\",\"drover\",\"spices\",\"gobbed\",\"corals\",\"chucks\",\"kitten\",\"whales\",\"nickel\",\"scrape\",\"hosted\""
+ "\r\n,\"hences\",\"morays\",\"stomps\",\"marcel\",\"hummed\",\"wonder\",\"stoves\",\"distil\",\"coffer\",\"quaker\",\"curler\""
+ "\r\n,\"nurses\",\"cabbed\",\"jigger\",\"grails\",\"manges\",\"larger\",\"zipped\",\"rovers\",\"stints\",\"nudges\",\"marlin\""
+ "\r\n,\"exuded\",\"storey\",\"pester\",\"longer\",\"creeps\",\"meaner\",\"wallop\",\"dewier\",\"rivera\",\"drones\",\"valued\""
+ "\r\n,\"bugled\",\"swards\",\"cortes\",\"charts\",\"benson\",\"wreaks\",\"glares\",\"levels\",\"smithy\",\"slater\",\"suites\""
+ "\r\n,\"paired\",\"fetter\",\"rutted\",\"levied\",\"menses\",\"wither\",\"woolly\",\"weeded\",\"planed\",\"censer\",\"tested\""
+ "\r\n,\"pulled\",\"hitter\",\"slicer\",\"tartar\",\"chunky\",\"whirrs\",\"mewled\",\"astern\",\"walden\",\"hilton\",\"cached\""
+ "\r\n,\"geller\",\"dolled\",\"chores\",\"sorter\",\"soothe\",\"reused\",\"clumps\",\"fueled\",\"hurler\",\"helled\",\"packed\""
+ "\r\n,\"ripped\",\"tanned\",\"binder\",\"flames\",\"teased\",\"punker\",\"jerked\",\"cannon\",\"joists\",\"whited\",\"sagged\""
+ "\r\n,\"heaven\",\"hansen\",\"grayer\",\"turfed\",\"cranks\",\"stater\",\"bunted\",\"horsey\",\"shakes\",\"brands\",\"faints\""
+ "\r\n,\"barber\",\"gorged\",\"creamy\",\"mowers\",\"scrams\",\"gashes\",\"knacks\",\"aeries\",\"sticks\",\"altars\",\"hostel\""
+ "\r\n,\"pumped\",\"reeves\",\"litter\",\"hoaxed\",\"mushed\",\"guided\",\"ripper\",\"bought\",\"gelled\",\"ranker\",\"jennie\""
+ "\r\n,\"blares\",\"saloon\",\"bomber\",\"mollie\",\"scoops\",\"coolie\",\"hollis\",\"shrunk\",\"tattle\",\"sensed\",\"gasket\""
+ "\r\n,\"dodoes\",\"mapped\",\"strips\",\"dodges\",\"sailed\",\"talked\",\"sorted\",\"lodges\",\"livest\",\"pastel\",\"ladles\""
+ "\r\n,\"graded\",\"thrice\",\"thales\",\"sagger\",\"mellon\",\"ganged\",\"maroon\",\"fluked\",\"raised\",\"nannie\",\"dearer\""
+ "\r\n,\"lither\",\"triked\",\"dorset\",\"clamps\",\"lonnie\",\"spates\",\"larded\",\"condor\",\"sinker\",\"narced\",\"quaver\""
+ "\r\n,\"atones\",\"farted\",\"elopes\",\"winger\",\"mottle\",\"loaned\",\"smears\",\"joanne\",\"boozes\",\"waster\",\"digger\""
+ "\r\n,\"swoops\",\"smokey\",\"nation\",\"drivel\",\"ceased\",\"miffed\",\"faiths\",\"pisses\",\"frames\",\"fooled\",\"milled\""
+ "\r\n,\"dither\",\"crazed\",\"darryl\",\"mulder\",\"posses\",\"sumter\",\"weasel\",\"pedals\",\"brawny\",\"charge\",\"welted\""
+ "\r\n,\"spanks\",\"sallow\",\"joined\",\"shaker\",\"blocks\",\"mattie\",\"swirls\",\"driver\",\"belles\",\"chomps\",\"blower\""
+ "\r\n,\"roared\",\"ratted\",\"hailed\",\"taunts\",\"steamy\",\"parrot\",\"deafer\",\"chewed\",\"spaces\",\"cuffed\",\"molded\""
+ "\r\n,\"winked\",\"runnel\",\"hollow\",\"fluted\",\"bedded\",\"crepes\",\"stakes\",\"vested\",\"parley\",\"burton\",\"loiter\""
+ "\r\n,\"massey\",\"carnap\",\"closed\",\"bailed\",\"milder\",\"heists\",\"morale\",\"putter\",\"snyder\",\"damion\",\"conned\""
+ "\r\n,\"little\",\"pooped\",\"ticced\",\"cocked\",\"halves\",\"wishes\",\"francs\",\"goblet\",\"carlin\",\"pecked\",\"julius\""
+ "\r\n,\"raster\",\"shocks\",\"dawned\",\"loosen\",\"swears\",\"buried\",\"peters\",\"treats\",\"noshed\",\"hedges\",\"trumps\""
+ "\r\n,\"rabies\",\"ronnie\",\"forces\",\"ticked\",\"bodies\",\"proved\",\"dadoes\",\"halved\",\"warner\",\"divest\",\"thumbs\""
+ "\r\n,\"fettle\",\"ponies\",\"testis\",\"ranked\",\"clouts\",\"slates\",\"tauted\",\"stools\",\"dodged\",\"chancy\",\"trawls\""
+ "\r\n,\"things\",\"sorrow\",\"levies\",\"glides\",\"battle\",\"sauced\",\"doomed\",\"seller\",\"strove\",\"ballet\",\"bumper\""
+ "\r\n,\"gooses\",\"foiled\",\"plowed\",\"glints\",\"chanel\",\"petals\",\"darted\",\"seared\",\"trunks\",\"hatter\",\"yokels\""
+ "\r\n,\"vanned\",\"tweedy\",\"rubles\",\"crones\",\"nettie\",\"roofed\",\"dusted\",\"dicker\",\"fakers\",\"rusted\",\"bedder\""
+ "\r\n,\"darrin\",\"bigger\",\"baylor\",\"crocks\",\"niches\",\"tented\",\"cashed\",\"splats\",\"quoted\",\"soloed\",\"tessie\""
+ "\r\n,\"stiles\",\"bearer\",\"hissed\",\"soiled\",\"adored\",\"bowery\",\"snakes\",\"wagers\",\"rafter\",\"crests\",\"plaids\""
+ "\r\n,\"cordon\",\"listed\",\"lawson\",\"scared\",\"brazos\",\"horded\",\"greens\",\"marred\",\"mushes\",\"hooper\",\"halter\""
+ "\r\n,\"ration\",\"calked\",\"erodes\",\"plumed\",\"mummer\",\"pinged\",\"curios\",\"slated\",\"ranter\",\"pillow\",\"frills\""
+ "\r\n,\"whaled\",\"bathos\",\"madden\",\"totted\",\"reamed\",\"bellow\",\"golfer\",\"seaman\",\"barred\",\"merger\",\"hipped\""
+ "\r\n,\"silken\",\"hastes\",\"strays\",\"slinks\",\"hooted\",\"convex\",\"singed\",\"leased\",\"bummed\",\"leaner\",\"molted\""
+ "\r\n,\"naught\",\"caters\",\"tidied\",\"forges\",\"sealer\",\"gulled\",\"plumps\",\"racket\",\"fitted\",\"rafted\",\"drapes\""
+ "\r\n,\"nasser\",\"tamara\",\"winced\",\"juliet\",\"ledger\",\"bettie\",\"howell\",\"reeved\",\"spiced\",\"thebes\",\"apices\""
+ "\r\n,\"dorsey\",\"welled\",\"feeler\",\"warded\",\"reader\",\"folded\",\"lepers\",\"cranky\",\"bosses\",\"ledges\",\"player\""
+ "\r\n,\"yellow\",\"lunged\",\"mattes\",\"confer\",\"malign\",\"shared\",\"brandy\",\"filmed\",\"rhinos\",\"pulsed\",\"rouses\""
+ "\r\n,\"stones\",\"mixers\",\"cooped\",\"joiner\",\"papped\",\"liston\",\"capote\",\"salvos\",\"wicker\",\"ciders\",\"hoofed\""
+ "\r\n,\"wefted\",\"locket\",\"picker\",\"nougat\",\"limpid\",\"hooter\",\"jailer\",\"peaces\",\"mashes\",\"custer\",\"wallis\""
+ "\r\n,\"purees\",\"trends\",\"irater\",\"honied\",\"wavers\",\"tanner\",\"change\",\"hinges\",\"tatted\",\"cookie\",\"catnap\""
+ "\r\n,\"carton\",\"crimed\",\"betted\",\"veined\",\"surges\",\"rumped\",\"merlin\",\"convey\",\"placid\",\"harped\",\"dianna\""
+ "\r\n,\"hookey\",\"nobles\",\"carted\",\"elided\",\"whined\",\"glover\",\"bleats\",\"stales\",\"husker\",\"hearer\",\"tartan\""
+ "\r\n,\"weaker\",\"skewer\",\"lumbar\",\"temper\",\"gigged\",\"gawked\",\"mayors\",\"pigged\",\"gather\",\"valves\",\"mitten\""
+ "\r\n,\"largos\",\"boreas\",\"judges\",\"cozens\",\"censor\",\"frilly\",\"dumbed\",\"downer\",\"jogger\",\"scolds\",\"danced\""
+ "\r\n,\"floras\",\"funded\",\"lumped\",\"dashes\",\"azores\",\"quites\",\"chunks\",\"washed\",\"duller\",\"bilges\",\"cruels\""
+ "\r\n,\"brooks\",\"fishes\",\"smoked\",\"leaped\",\"hotter\",\"trials\",\"heaves\",\"rouges\",\"kissed\",\"sleety\",\"manses\""
+ "\r\n,\"spites\",\"starts\",\"banded\",\"clings\",\"titted\",\"vetoed\",\"mister\",\"mildew\",\"wailed\",\"sheets\",\"peeked\""
+ "\r\n,\"passer\",\"felted\",\"broken\",\"lieges\",\"ruffed\",\"bracts\",\"buster\",\"muffed\",\"lanker\",\"breaks\",\"coffey\""
+ "\r\n,\"sighed\",\"charms\",\"balded\",\"kisser\",\"booths\",\"leaven\",\"cheeps\",\"billed\",\"lauder\",\"bumped\",\"career\""
+ "\r\n,\"stocks\",\"airier\",\"limped\",\"jeanie\",\"roamed\",\"carves\",\"lilted\",\"router\",\"bonnie\",\"denver\",\"briggs\""
+ "\r\n,\"steeps\",\"nerves\",\"oinked\",\"bucked\",\"hooves\",\"dancer\",\"burris\",\"parked\",\"swells\",\"collie\",\"perked\""
+ "\r\n,\"cooler\",\"fopped\",\"wedder\",\"malted\",\"sabers\",\"lidded\",\"conner\",\"rogues\",\"fought\",\"dapper\",\"purled\""
+ "\r\n,\"crowds\",\"barnes\",\"bonner\",\"globed\",\"goners\",\"yankee\",\"probes\",\"trains\",\"sayers\",\"jersey\",\"valley\""
+ "\r\n,\"vatted\",\"tauter\",\"dulled\",\"mucked\",\"jotted\",\"border\",\"genres\",\"banked\",\"filter\",\"hitler\",\"dipper\""
+ "\r\n,\"dollie\",\"sieves\",\"joliet\",\"tilted\",\"checks\",\"sports\",\"soughs\",\"ported\",\"causes\",\"gelded\",\"mooter\""
+ "\r\n,\"grills\",\"parred\",\"tipped\",\"placer\",\"slayer\",\"glided\",\"basked\",\"rinses\",\"tamper\",\"bunged\",\"nabbed\""
+ "\r\n,\"climbs\",\"faeces\",\"hanson\",\"brainy\",\"wicket\",\"crowns\",\"calmed\",\"tarred\",\"spires\",\"deanne\",\"gravel\""
+ "\r\n,\"messes\",\"snides\",\"tugged\",\"denier\",\"moslem\",\"erased\",\"mutter\",\"blahed\",\"hunker\",\"fasten\",\"garbed\""
+ "\r\n,\"cracks\",\"braked\",\"rasped\",\"ravens\",\"mutton\",\"tester\",\"tories\",\"pinker\",\"titled\",\"arisen\",\"softer\""
+ "\r\n,\"woolen\",\"disses\",\"likest\",\"dicier\",\"nagged\",\"lipton\",\"plumbs\",\"manged\",\"faulty\",\"sacred\",\"whiter\""
+ "\r\n,\"erases\",\"padres\",\"haired\",\"captor\",\"metals\",\"cardin\",\"yowled\",\"trusts\",\"revels\",\"boxers\",\"toured\""
+ "\r\n,\"spouts\",\"sodded\",\"judged\",\"holley\",\"figged\",\"pricey\",\"lapses\",\"harper\",\"beaned\",\"sewers\",\"caused\""
+ "\r\n,\"willie\",\"farmer\",\"pissed\",\"bevies\",\"bolled\",\"bugler\",\"votive\",\"person\",\"linton\",\"senses\",\"supped\""
+ "\r\n,\"mashed\",\"pincer\",\"wetter\",\"tangos\",\"sticky\",\"lodger\",\"loader\",\"daunts\",\"peaked\",\"moused\",\"sleeps\""
+ "\r\n,\"lasted\",\"tasked\",\"awards\",\"lovely\",\"gushed\",\"spurts\",\"canter\",\"mantis\",\"coaled\",\"groans\",\"dannie\""
+ "\r\n,\"oopses\",\"sneaky\",\"vogues\",\"mobile\",\"plumes\",\"chides\",\"theses\",\"marcia\",\"parser\",\"flexed\",\"stayed\""
+ "\r\n,\"fouler\",\"tusked\",\"quartz\",\"daubed\",\"clancy\",\"rouged\",\"flaked\",\"norton\",\"dunner\",\"corded\",\"shelly\""
+ "\r\n,\"hester\",\"fucker\",\"polled\",\"rodger\",\"yeager\",\"zinced\",\"livens\",\"browne\",\"gonged\",\"pubbed\",\"sapped\""
+ "\r\n,\"thrive\",\"placed\",\"jensen\",\"moises\",\"scopes\",\"stumpy\",\"stocky\",\"heller\",\"levers\",\"morals\",\"wheres\""
+ "\r\n,\"gasped\",\"jobber\",\"leaved\",\"champs\",\"rosier\",\"pallet\",\"shooed\",\"parses\",\"bender\",\"closet\",\"pureed\""
+ "\r\n,\"routes\",\"verges\",\"bulled\",\"foster\",\"rummer\",\"molten\",\"condos\",\"better\",\"cotter\",\"lassos\",\"grafts\""
+ "\r\n,\"vendor\",\"thrace\",\"codded\",\"tinker\",\"bullet\",\"beaker\",\"garden\",\"spiels\",\"popper\",\"skills\",\"plated\""
+ "\r\n,\"farrow\",\"flexes\",\"esters\",\"brains\",\"handel\",\"puller\",\"dickey\",\"creeks\",\"ballot\",\"singer\",\"sicker\""
+ "\r\n,\"spayed\",\"spoils\",\"rubier\",\"missed\",\"framed\",\"bonnet\",\"molder\",\"mugger\",\"waived\",\"taster\",\"robles\""
+ "\r\n,\"tracks\",\"nearer\",\"lister\",\"horsed\",\"drakes\",\"lopped\",\"lubber\",\"busied\",\"button\",\"eluded\",\"ceases\""
+ "\r\n,\"sought\",\"realer\",\"lasers\",\"pollen\",\"crisps\",\"binned\",\"darrel\",\"crafty\",\"gleams\",\"lonely\",\"gordon\""
+ "\r\n,\"harley\",\"damian\",\"whiles\",\"wilton\",\"lesser\",\"mallow\",\"kenyon\",\"wimped\",\"scened\",\"risked\",\"hunter\""
+ "\r\n,\"rooter\",\"ramses\",\"inches\",\"goaded\",\"ferber\",\"freaky\",\"nerved\",\"spoken\",\"lovers\",\"letter\",\"marrow\""
+ "\r\n,\"bulbed\",\"braver\",\"sloped\",\"breads\",\"cannes\",\"bassos\",\"orated\",\"clever\",\"darren\",\"bredes\",\"gouger\""
+ "\r\n,\"servos\",\"trites\",\"troths\",\"flunky\",\"jammed\",\"bugged\",\"watter\",\"motive\",\"humped\",\"writer\",\"pestle\""
+ "\r\n,\"rilled\",\"packer\",\"foists\",\"croats\",\"floury\",\"napier\",\"floors\",\"scotty\",\"sevens\",\"harrow\",\"welter\""
+ "\r\n,\"quacks\",\"daybed\",\"lorded\",\"pulses\",\"pokier\",\"fatten\",\"midges\",\"joints\",\"snoopy\",\"looter\",\"monies\""
+ "\r\n,\"canted\",\"riffed\",\"misses\",\"bunker\",\"piston\",\"yessed\",\"earner\",\"hawked\",\"wedged\",\"brewer\",\"nested\""
+ "\r\n,\"graver\",\"hoaxes\",\"slaves\",\"pricks\",\"magpie\",\"bernie\",\"rapier\",\"roster\",\"poohed\",\"corner\",\"trysts\""
+ "\r\n,\"rogers\",\"whirls\",\"bathed\",\"teasel\",\"opener\",\"minced\",\"sister\",\"dreamy\",\"worker\",\"rinked\",\"panted\""
+ "\r\n,\"triton\",\"mervin\",\"snowed\",\"leafed\",\"thinks\",\"lesson\",\"millet\",\"larson\",\"lagged\",\"likely\",\"stormy\""
+ "\r\n,\"fortes\",\"hordes\",\"wovens\",\"kinked\",\"mettle\",\"seated\",\"shirts\",\"solver\",\"giants\",\"jilted\",\"leaded\""
+ "\r\n,\"mendez\",\"lowers\",\"bidder\",\"greats\",\"pepped\",\"flours\",\"versus\",\"canton\",\"weller\",\"cowper\",\"tapped\""
+ "\r\n,\"dueled\",\"mussed\",\"rubies\",\"bonged\",\"steals\",\"formed\",\"smalls\",\"sculls\",\"docket\",\"ouster\",\"gunned\""
+ "\r\n,\"thumps\",\"curred\",\"withes\",\"putted\",\"buttes\",\"bloats\",\"parsed\",\"galley\",\"preses\",\"tagged\",\"hanger\""
+ "\r\n,\"planes\",\"chords\",\"shafts\",\"carson\",\"posits\",\"zinger\",\"solves\",\"tensed\",\"tastes\",\"rinsed\",\"kenned\""
+ "\r\n,\"bitten\",\"leslie\",\"chanty\",\"candor\",\"daises\",\"baggie\",\"wedded\",\"paints\",\"moored\",\"haloed\",\"hornet\""
+ "\r\n,\"lifted\",\"fender\",\"guiles\",\"swifts\",\"flicks\",\"lancer\",\"spares\",\"pellet\",\"passed\",\"finked\",\"joanna\""
+ "\r\n,\"bidden\",\"swamps\",\"lapped\",\"leered\",\"served\",\"shirrs\",\"choker\",\"limper\",\"marker\",\"nudged\",\"triter\""
+ "\r\n,\"thanks\",\"peered\",\"bruins\",\"loaves\",\"fabled\",\"lathes\",\"pipers\",\"hooped\",\"orates\",\"burned\",\"swines\""
+ "\r\n,\"sprats\",\"warder\",\"colder\",\"crazes\",\"reined\",\"prized\",\"majors\",\"darrow\",\"waifed\",\"rooked\",\"rickey\""
+ "\r\n,\"patter\",\"shrive\",\"gropes\",\"gassed\",\"throve\",\"region\",\"weaken\",\"hettie\",\"walton\",\"galled\",\"convoy\""
+ "\r\n,\"wesson\",\"exudes\",\"tinted\",\"clanks\",\"blinks\",\"slacks\",\"stilts\",\"franny\",\"socket\",\"wished\",\"kidded\""
+ "\r\n,\"knotty\",\"turves\",\"cashes\",\"geared\",\"sunned\",\"glowed\",\"sadden\",\"harlem\",\"testes\",\"sweets\",\"becket\""
+ "\r\n,\"blazes\",\"batter\",\"fellow\",\"clovis\",\"copier\",\"shaped\",\"husked\",\"gimlet\",\"rooney\",\"taints\",\"sashes\""
+ "\r\n,\"bossed\",\"cootie\",\"franck\",\"probed\",\"bagged\",\"smocks\",\"batten\",\"spared\",\"chills\",\"relics\",\"meyers\""
+ "\r\n,\"grader\",\"tromps\",\"dimmer\",\"pasted\",\"pepper\",\"capped\",\"played\",\"junket\",\"easier\",\"palmed\",\"pander\""
+ "\r\n,\"vaguer\",\"bulged\",\"dissed\",\"borges\",\"raises\",\"wallow\",\"jigged\",\"bogged\",\"burped\",\"neater\",\"rammed\""
+ "\r\n,\"fibers\",\"castor\",\"skirts\",\"cancer\",\"tilled\",\"spored\",\"dander\",\"denims\",\"budges\",\"trucks\",\"sowers\""
+ "\r\n,\"yapped\",\"cadges\",\"wrists\",\"hacker\",\"graved\",\"vipers\",\"noshes\",\"minted\",\"lessor\",\"cassia\",\"wrecks\""
+ "\r\n,\"hidden\",\"brando\",\"honeys\",\"chilli\",\"ragged\",\"breded\",\"punier\",\"stacey\",\"sisses\",\"jocked\",\"croaks\""
+ "\r\n,\"dinned\",\"walker\",\"heston\",\"flares\",\"coined\",\"cannot\",\"chocks\",\"leases\",\"wander\",\"balder\",\"warmer\""
+ "\r\n,\"bawled\",\"donnie\",\"damson\",\"header\",\"chilly\",\"models\",\"simper\",\"watery\",\"milked\",\"poises\",\"combed\""
+ "\r\n,\"toilet\",\"gallop\",\"sonnet\",\"loosed\",\"yawned\",\"splays\",\"pauses\",\"bother\",\"graphs\",\"shrews\",\"scones\""
+ "\r\n,\"manuel\",\"milers\",\"hotels\",\"bennie\",\"flores\",\"spells\",\"grimed\",\"tenses\",\"staged\",\"puffer\",\"posies\""
+ "\r\n,\"motion\",\"fudged\",\"fainer\",\"tatter\",\"seraph\",\"nansen\",\"months\",\"muppet\",\"tamera\",\"shaman\",\"falser\""
+ "\r\n,\"becker\",\"lisbon\",\"clefts\",\"weeper\",\"mendel\",\"girder\",\"takers\",\"torsos\",\"forked\",\"dances\",\"stated\""
+ "\r\n,\"yelled\",\"scants\",\"frothy\",\"rolled\",\"yodels\",\"listen\",\"craned\",\"brooms\",\"suffer\",\"easter\",\"shills\""
+ "\r\n,\"craves\",\"bleeps\",\"belled\",\"dished\",\"bordon\",\"zither\",\"jacket\",\"lammer\",\"kirked\",\"shaved\",\"atoned\""
+ "\r\n,\"frumpy\",\"nosier\",\"vender\",\"graced\",\"clingy\",\"chants\",\"wrests\",\"cursed\",\"prunes\",\"tarter\",\"stripe\""
+ "\r\n,\"coffee\",\"veiled\",\"tweeds\",\"shrine\",\"spines\",\"kegged\",\"melvin\",\"gasser\",\"market\",\"marten\",\"peeped\""
+ "\r\n,\"sanger\",\"somber\",\"spider\",\"netted\",\"radium\",\"slings\",\"scarfs\",\"mended\",\"creels\",\"shaves\",\"payers\""
+ "\r\n,\"bunked\",\"movers\",\"beings\",\"conked\",\"cozies\",\"benton\",\"codger\",\"prints\",\"gusset\",\"longed\",\"burner\""
+ "\r\n,\"jambed\",\"mullet\",\"fogged\",\"scores\",\"carbon\",\"sleeks\",\"helped\",\"waxier\",\"gilded\",\"harlot\",\"winces\""
+ "\r\n,\"tenser\",\"lowell\",\"ramsey\",\"kennan\",\"booted\",\"beaver\",\"rested\",\"shouts\",\"hickey\",\"looped\",\"swings\""
+ "\r\n,\"wonted\",\"dilled\",\"defers\",\"lolled\",\"pupped\",\"cruets\",\"solved\",\"romper\",\"defter\",\"chokes\",\"kithed\""
+ "\r\n,\"garnet\",\"bookie\",\"stared\",\"stares\",\"latter\",\"lazies\",\"fanned\",\"wagged\",\"dunces\",\"corked\",\"cloned\""
+ "\r\n,\"prided\",\"baxter\",\"pusses\",\"boomed\",\"masses\",\"warren\",\"weaves\",\"delves\",\"handed\",\"merton\",\"lusher\""
+ "\r\n,\"hepper\",\"gibber\",\"sender\",\"parsec\",\"snares\",\"masher\",\"seamed\",\"sweats\",\"welles\",\"gagged\",\"curter\""
+ "\r\n,\"mother\",\"beeped\",\"vealed\",\"shoved\",\"slaver\",\"hacked\",\"gutted\",\"ranged\",\"bashed\",\"closer\",\"storks\""
+ "\r\n,\"meshed\",\"cortex\",\"copper\",\"severn\",\"gripes\",\"carlos\",\"scares\",\"crates\",\"boiled\",\"ginned\",\"mouses\""
+ "\r\n,\"raided\",\"greyed\",\"verier\",\"slopes\",\"fenced\",\"sniper\",\"priced\",\"flawed\",\"buffed\",\"spacey\",\"favors\""
+ "\r\n,\"platen\",\"miller\",\"walled\",\"cutter\",\"skated\",\"holier\",\"beamed\",\"waiter\",\"drowns\",\"clomps\",\"quarks\""
+ "\r\n,\"bested\",\"frisks\",\"purged\",\"scalds\",\"marian\",\"flower\",\"howled\",\"plover\",\"bikers\",\"trails\",\"hagged\""
+ "\r\n,\"smirks\",\"sitter\",\"carmen\",\"lanced\",\"plants\",\"nobler\",\"yakked\",\"thesis\",\"lassen\",\"margin\",\"wagner\""
+ "\r\n,\"sifter\",\"houses\",\"screws\",\"booker\",\"dormer\",\"meters\",\"padded\",\"loaded\",\"cartel\",\"sutton\",\"willis\""
+ "\r\n,\"chatty\",\"dunked\",\"dreamt\",\"dalton\",\"fables\",\"coveys\",\"muller\",\"shanty\",\"adders\",\"tailor\",\"helper\""
+ "\r\n,\"liters\",\"butted\",\"maiman\",\"hollie\",\"gallon\",\"xavier\",\"shrank\",\"mickey\",\"rather\",\"powers\",\"keened\""
+ "\r\n,\"doused\",\"kisses\",\"flanks\",\"dotted\",\"phased\",\"dumped\",\"linger\",\"kramer\",\"spaced\",\"soften\",\"strife\""
+ "\r\n,\"rowers\",\"hovers\",\"crimes\",\"crooks\",\"carrel\",\"braces\",\"lander\",\"shrove\",\"skulks\",\"banker\",\"itches\""
+ "\r\n,\"dropsy\",\"misted\",\"pulped\",\"cloche\",\"fawned\",\"states\",\"teared\",\"beeper\",\"raider\",\"groves\",\"livery\""
+ "\r\n,\"aerier\",\"keenan\",\"severe\",\"sabres\",\"bogies\",\"coated\",\"harlow\",\"tanked\",\"mellow\",\"cozier\",\"shanks\""
+ "\r\n,\"spooky\",\"blamed\",\"tricks\",\"sleets\",\"punted\",\"jumped\",\"caxton\",\"warped\",\"halley\",\"frisky\",\"shines\""
+ "\r\n,\"skater\",\"lumber\",\"truces\",\"sliced\",\"gibbet\",\"narked\",\"chives\",\"graves\",\"gummed\",\"holler\",\"glazes\""
+ "\r\n,\"nieves\",\"hushed\",\"nought\",\"prated\",\"chored\",\"cloudy\",\"kidder\",\"huston\",\"straws\",\"twined\",\"gifted\""
+ "\r\n,\"rodney\",\"haloes\",\"france\",\"wirier\",\"mercia\",\"rubbed\",\"coaxed\",\"sumner\",\"snipes\",\"nipper\",\"leiden\""
+ "\r\n,\"madman\",\"margie\",\"footed\",\"firmed\",\"budded\",\"froths\",\"senior\",\"hoover\",\"tailed\",\"glider\",\"straps\""
+ "\r\n,\"stalks\",\"billow\",\"racked\",\"javier\",\"zoomed\",\"shades\",\"whores\",\"braids\",\"roused\",\"sudden\",\"dogies\""
+ "\r\n,\"fencer\",\"snaked\",\"flings\",\"traded\",\"gunner\",\"snider\",\"staten\",\"levees\",\"lathed\",\"sailor\",\"waited\""
+ "\r\n,\"muster\",\"clothe\",\"lulled\",\"cargos\",\"revved\",\"sooths\",\"flamed\",\"borers\",\"feller\",\"bladed\",\"oliver\""
+ "\r\n,\"collin\",\"wusses\",\"murder\",\"parted\",\"jailed\",\"frayed\",\"doored\",\"cheeks\",\"misled\",\"belted\",\"winter\""
+ "\r\n,\"merges\",\"shaven\",\"fudges\",\"tabbed\",\"forget\",\"sloths\",\"cachet\",\"mealed\",\"sassed\",\"salter\",\"haunts\""
+ "\r\n,\"ranger\",\"rivets\",\"deeded\",\"reaped\",\"damped\",\"crated\",\"youths\",\"whacks\",\"tamers\",\"misery\",\"seeped\""
+ "\r\n,\"eerier\",\"tiller\",\"busses\",\"gloved\",\"hushes\",\"cronus\",\"pruned\",\"casket\",\"direst\",\"guilds\",\"motley\""
+ "\r\n,\"spools\",\"fevers\",\"snores\",\"greece\",\"elides\",\"waists\",\"rattle\",\"trader\",\"juster\",\"rashes\",\"stoney\""
+ "\r\n,\"pipped\",\"solder\",\"sinner\",\"prides\",\"rugged\",\"steers\",\"gnarly\",\"titter\",\"cities\",\"walter\",\"stolen\""
+ "\r\n,\"steaks\",\"hawker\",\"weaned\",\"jobbed\",\"jacked\",\"pikers\",\"hipper\",\"spoilt\",\"beeves\",\"craved\",\"gotten\""
+ "\r\n,\"balked\",\"sherry\",\"looney\",\"crisis\",\"callie\",\"swiped\",\"fished\",\"rooted\",\"bopped\",\"bowler\",\"escher\""
+ "\r\n,\"chumps\",\"jerrod\",\"lefter\",\"snooty\",\"fillet\",\"scales\",\"comets\",\"lisped\",\"decked\",\"clowns\",\"horned\""
+ "\r\n,\"robber\",\"bottle\",\"reeled\",\"crapes\",\"banter\",\"martel\",\"dowels\",\"brandt\",\"sweeps\",\"heeled\",\"tabled\""
+ "\r\n,\"manors\",\"danger\",\"dionne\",\"prayer\",\"decker\",\"millie\",\"boated\",\"damned\",\"horses\",\"globes\",\"failed\""
+ "\r\n,\"lammed\",\"nigher\",\"joyner\",\"sobers\",\"chided\",\"tipper\",\"parcel\",\"flakes\",\"fugger\",\"elated\",\"hinder\""
+ "\r\n,\"hopper\",\"crafts\",\"wipers\",\"badder\",\"jessie\",\"matted\",\"wafted\",\"pealed\",\"cheats\",\"elites\",\"torres\""
+ "\r\n,\"bushed\",\"sneaks\",\"tidies\",\"brings\",\"stalls\",\"payees\",\"zonked\",\"danker\",\"poshes\",\"smelts\",\"stoops\""
+ "\r\n,\"warden\",\"chicks\",\"ramsay\",\"budged\",\"firmer\",\"glazed\",\"heated\",\"slices\",\"hovels\",\"belied\",\"shifts\""
+ "\r\n,\"pauper\",\"tinges\",\"weston\",\"casted\",\"titles\",\"droves\",\"roomer\",\"modals\",\"seamen\",\"wearer\",\"blonde\""
+ "\r\n,\"berlin\",\"libbed\",\"tensor\",\"hokier\",\"lambed\",\"graped\",\"headed\",\"copped\",\"eroses\",\"fagged\",\"filler\""
+ "\r\n,\"keener\",\"stages\",\"civets\",\"spills\",\"tithed\",\"sullen\",\"sucked\",\"briton\",\"whaler\",\"hooded\",\"tittle\""
+ "\r\n,\"bucket\",\"furled\",\"darned\",\"planet\",\"clucks\",\"batted\",\"dagger\",\"brides\",\"severs\",\"pathos\",\"grainy\""
+ "\r\n,\"relied\",\"carpel\",\"makers\",\"lancet\",\"slowed\",\"messed\",\"ravels\",\"faster\",\"gabbed\",\"chance\",\"grayed\""
+ "\r\n,\"santos\",\"spends\",\"chinos\",\"saints\",\"swirly\",\"dories\",\"wilson\",\"milton\",\"clangs\",\"manual\",\"nodded\""
+ "\r\n,\"signer\",\"stript\",\"etched\",\"vaster\",\"wastes\",\"stored\",\"minces\",\"purred\",\"marvin\",\"pinned\",\"skulls\""
+ "\r\n,\"heaved\",\"wadded\",\"fowled\",\"hashed\",\"mullen\",\"relief\",\"hatted\",\"primed\",\"chaffs\",\"canned\",\"lackey\""
+ "\r\n,\"showed\",\"shandy\",\"chases\",\"maggie\",\"deafen\",\"bussed\",\"differ\",\"worked\",\"marted\",\"ducked\",\"socked\""
+ "\r\n,\"fussed\",\"greyer\",\"herder\",\"trusty\",\"follow\",\"samson\",\"babies\",\"whorls\",\"stanks\",\"manson\",\"cranes\""
+ "\r\n,\"murrow\",\"shrink\",\"genius\",\"holder\",\"lenses\",\"yucked\",\"termed\",\"ruined\",\"junker\",\"belies\",\"joshed\""
+ "\r\n,\"cooled\",\"basted\",\"greeks\",\"fuller\",\"healer\",\"carver\",\"havens\",\"drunks\",\"sucker\",\"lotion\",\"glared\""
+ "\r\n,\"healed\",\"pocked\",\"rifles\",\"weaved\",\"canoed\",\"punter\",\"hinton\",\"settle\",\"boobed\",\"hinted\",\"scored\""
+ "\r\n,\"harder\",\"status\",\"sloven\",\"hayden\",\"golfed\",\"scoots\",\"bloods\",\"slaked\",\"jugged\",\"louses\",\"cassie\""
+ "\r\n,\"shaded\",\"rushed\",\"pitied\",\"barked\",\"honked\",\"rasher\",\"forced\",\"shaver\",\"vowels\",\"holden\",\"pelvis\""
+ "\r\n,\"blades\",\"chests\",\"preyer\",\"floods\",\"deanna\",\"cation\",\"mapper\",\"falter\",\"dabbed\",\"mocker\",\"nestle\""
+ "\r\n,\"shucks\",\"heeded\",\"ticker\",\"binges\",\"summer\",\"slumps\",\"lusted\",\"scampi\",\"crofts\",\"gorges\",\"pardon\""
+ "\r\n,\"torses\",\"smokes\",\"lashed\",\"bailey\",\"jabbed\",\"calmer\",\"preset\",\"forbes\",\"hasted\",\"wormed\",\"winged\""
+ "\r\n,\"minors\",\"banner\",\"grazed\",\"hewers\",\"kernel\",\"jolted\",\"sniped\",\"clunky\",\"ratios\",\"blinds\",\"ganges\""
+ "\r\n,\"misers\",\"spikes\",\"riders\",\"hallow\",\"grumpy\",\"barren\",\"summed\",\"infers\",\"places\",\"jarred\",\"killer\""
+ "\r\n,\"plaint\",\"goofed\",\"subbed\",\"prudes\",\"sipped\",\"kookie\",\"whines\",\"droopy\",\"palled\",\"cherry\",\"proves\""
+ "\r\n,\"mobbed\",\"spaded\",\"cheese\",\"pluses\",\"bathes\",\"motels\",\"spewed\",\"soaked\",\"howler\",\"puffed\",\"malled\""
+ "\r\n,\"shrike\",\"slided\",\"fulled\",\"pouted\",\"shames\",\"lessen\",\"ringed\",\"teemed\",\"grands\",\"linked\",\"wooten\""
+ "\r\n,\"feuded\",\"deaden\",\"scents\",\"flutes\",\"salton\"]"
		+ "\r\n"
			+ "\r\n"/**}*/;
		
		List<String> wordList = ParamUtil.str2List(str);
		Date start = new Date();
		Object result = test.findLadders(beginWord,endWord,wordList);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
		
	}
	
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		if(!wordList.contains(endWord))	{
			return new ArrayList<List<String>>();
		}
		if(isReach(beginWord,endWord))	{
			List<List<String>> result = new ArrayList<List<String>>();
			List<String> subResult = new ArrayList<String>();
			subResult.add(beginWord);
			subResult.add(endWord);
			result.add(subResult);
			return result;
		}
		wordList.remove(endWord);
		Map<String,Set<String>> roadMap = new HashMap<String,Set<String>>();
		Set<String> usedStr = new HashSet<String>();
		Set<String> targetList = new HashSet<String>();
		usedStr.add(endWord);
		targetList.add(endWord);
		boolean isFind = false;
		while(!targetList.isEmpty() && !isFind)	{
			Set<String> newTargetList = new HashSet<String>();
			Set<String> usedTemp = new HashSet<String>();
			for(String target : targetList)	{
				for(String word : wordList)	{
					if(!usedStr.contains(word) && isReach(word,target))	{
						putIntoMap(roadMap, word,target);
						usedTemp.add(word);
						newTargetList.add(word);
					}
				}
				if(isReach(beginWord,target))	{
					isFind = true;
					putIntoMap(roadMap,beginWord,target);
				}
			}
			usedStr.addAll(usedTemp);
			targetList = newTargetList;
		}
		List<List<String>> result = new ArrayList<List<String>>();
		if(!isFind)	{
			return result;
		}
		List<String> subReuslt = new ArrayList<String>();
		subReuslt.add(beginWord);
		result.add(subReuslt);
		boolean isOver = false;
		while(!isOver)	{
			List<List<String>> tempResult = new ArrayList<List<String>>();
			for(List<String> subList : result)	{
				Set<String> target = roadMap.get(subList.get(subList.size()-1));
				List<String> copyList = new ArrayList<String>();
				if(target.size() > 1)	{
					copyList.addAll(subList);
				}
				int index = 0;
				for(String next : target)	{
					if(next.equals(endWord))	{
						isOver = true;
					}
					if(index==0)	{
						subList.add(next);
					} else {
						List<String> newList = new ArrayList<String>();
						newList.addAll(copyList);
						newList.add(next);
						tempResult.add(newList);
					}
					index++;
				}
			}
			result.addAll(tempResult);
		}
		return result;
    }
	private void putIntoMap(Map<String,Set<String>> roadMap,String key,String word)	{
		Set<String> targetList = roadMap.get(key);
		if(targetList == null)	{
			targetList = new HashSet<String>();
			roadMap.put(key,targetList);
		}
		targetList.add(word);
	}
	private boolean isReach(String from,String to)	{
		int diffNum = 0;
		for(int i=0;i<from.length();i++)	{
			if(from.charAt(i) != to.charAt(i))	{
				diffNum++;
				if(diffNum > 1)	{
					return false;
				}
			}
		}
		if(diffNum == 1)	{
			return true;
		} else {
			return false;
		}
	}
}

