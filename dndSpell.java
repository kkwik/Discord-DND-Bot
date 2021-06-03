import java.util.*;

/**
 * An Enum that represents all valid spells the bot knows.
 * Each value contains a formatted name, spell level, spell school, and a HashSet of the classes that can use it
 */
public enum dndSpell {
    //PHB Spells
    ACIDSPLASH ("Acid Splash", (byte)0, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    AID ("Aid", (byte)2, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.CLERIC, dndClass.PALADIN}),
    ALARM ("Alarm", (byte)1, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.RANGER, dndClass.WIZARD}),
    ALTERSELF ("Alter Self", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    ANIMALFRIENDSHIP ("Animal Friendship", (byte)1, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.DRUID, dndClass.RANGER}),
    ANIMALMESSENGER ("Animal Messenger", (byte)2, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARBARIAN, dndClass.DRUID, dndClass.RANGER}),
    ANIMALSHAPES ("Animal Shapes", (byte)8, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID}),
    ANIMATEDEAD ("Animate Dead", (byte)3, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.CLERIC, dndClass.WIZARD}),
    ANIMATEOBJECTS ("Animate Objects", (byte)5, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WIZARD}),
    ANTILIFESHELL ("Antilife Shell", (byte)5, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.DRUID}),
    ANTIMAGICFIELD ("Antimagic Field", (byte)8, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.CLERIC, dndClass.WIZARD}),
    ANTIPATHYSYMPATHY ("Antipathy/Sympathy", (byte)8, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.DRUID, dndClass.WIZARD}),
    ARCANEEYE ("Arcane Eye", (byte)4, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.WIZARD}),
    ARCANEGATE ("Arcane Gate", (byte)6, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    ARCANELOCK ("Arcane Lock", (byte)2, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.WIZARD}),
    ARMOROFAGATHYS ("Armor Of Agathys", (byte)1, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.WARLOCK}),
    ARMSOFHADAR ("Arms Of Hadar", (byte)1, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.WARLOCK}),
    ASTRALPROJECTION ("Astral Projection", (byte)9, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.CLERIC, dndClass.WARLOCK, dndClass.WIZARD}),
    AUGURY ("Augury", (byte)2, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.CLERIC}),
    AURAOFLIFE ("Aura Of Life", (byte)4, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.PALADIN}),
    AURAOFPURITY ("Aura Of Purity", (byte)4, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.PALADIN}),
    AURAOFVITALITY ("Aura Of Vitality", (byte)3, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.PALADIN}),
    AWAKEN ("Awaken", (byte)5, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.BARD, dndClass.DRUID}),
    BANE ("Bane", (byte)1, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.CLERIC}),
    BANISHINGSMITE ("Banishing Smite", (byte)5, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.PALADIN}),
    BANISHMENT ("Banishment", (byte)4, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.CLERIC, dndClass.PALADIN, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    BARKSKIN ("Barkskin", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER}),
    BEACONOFHOPE ("Beacon Of Hope", (byte)3, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.CLERIC}),
    BEASTSENSE ("Beast Sense", (byte)2, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER}),
    BESTOWCURSE ("Bestow Curse", (byte)3, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.WIZARD}),
    BIGBYSHAND ("Bigby's Hand", (byte)5, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.WIZARD}),
    BLADEBARRIER ("Blade Barrier", (byte)6, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.CLERIC}),
    BLADEWARD ("Blade Ward", (byte)0, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    BLESS ("Bless", (byte)1, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.CLERIC, dndClass.PALADIN}),
    BLIGHT ("Blight", (byte)4, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    BLINDINGSMITE ("Blinding Smite", (byte)3, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.PALADIN}),
    BLINDNESSDEAFNESS ("Blindness/Deafness", (byte)2, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.SORCERER, dndClass.WIZARD}),
    BLINK ("Blink", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    BLUR ("Blur", (byte)2, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    BRANDINGSMITE ("Branding Smite", (byte)2, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.PALADIN}),
    BURNINGHANDS ("Burning Hands", (byte)1, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    CALLLIGHTNING ("Call Lightning", (byte)3, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID}),
    CALMEMOTIONS ("Calm Emotions", (byte)2, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.CLERIC}),
    CHAINLIGHTNING ("Chain Lightning", (byte)6, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    CHARMPERSON ("Charm Person", (byte)1, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.DRUID, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    CHILLTOUCH ("Chill Touch", (byte)0, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    CHROMATICORB ("Chromatic Orb", (byte)1, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    CIRCLEOFDEATH ("Circle Of Death", (byte)6, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    CIRCLEOFPOWER ("Circle Of Power", (byte)5, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.PALADIN}),
    CLAIRVOYANCE ("Clairvoyance", (byte)3, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.SORCERER, dndClass.WIZARD}),
    CLONE ("Clone", (byte)8, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.WIZARD}),
    CLOUDOFDAGGERS ("Cloud Of Daggers", (byte)2, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    CLOUDKILL ("Cloudkill", (byte)5, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    COLORSPRAY ("Color Spray", (byte)1, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    COMMAND ("Command", (byte)1, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.CLERIC, dndClass.PALADIN}),
    COMMUNE ("Commune", (byte)5, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.CLERIC}),
    COMMUNEWITHNATURE ("Commune with Nature", (byte)5, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER}),
    COMPELLEDDUEL ("Compelled Duel", (byte)1, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.PALADIN}),
    COMPREHENDLANGUAGES ("Comprehend Languages", (byte)1, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    COMPULSION ("Compulsion", (byte)4, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD}),
    CONEOFCOLD ("Cone Of Cold", (byte)5, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    CONFUSION ("Confusion", (byte)4, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    CONJUREANIMALS ("Conjure Animals", (byte)3, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER}),
    CONJUREBARRAGE ("Conjure Barrage", (byte)3, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.RANGER}),
    CONJURECELESTIAL ("Conjure Celestial", (byte)7, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.CLERIC}),
    CONJUREELEMENTAL ("Conjure Elemental", (byte)5, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID, dndClass.WIZARD}),
    CONJUREFEY ("Conjure Fey", (byte)6, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID, dndClass.WARLOCK}),
    CONJUREMINORELEMENTALS ("Conjure Minor Elementals", (byte)4, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID, dndClass.WIZARD}),
    CONJUREVOLLEY ("Conjure Volley", (byte)5, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.RANGER}),
    CONJUREWOODLANDBEINGS ("Conjure Woodland Beings", (byte)4, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER}),
    CONTACTOTHERPLANE ("Contact Other Plane", (byte)5, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.WARLOCK, dndClass.WIZARD}),
    CONTAGION ("Contagion", (byte)5, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.CLERIC, dndClass.DRUID}),
    CONTINGENCY ("Contingency", (byte)6, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.WIZARD}),
    CONTINUALFLAME ("Continual Flame", (byte)2, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.CLERIC, dndClass.WIZARD}),
    CONTROLWATER ("Control Water", (byte)4, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.CLERIC, dndClass.DRUID, dndClass.WIZARD}),
    CONTROLWEATHER ("Control Weather", (byte)8, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.CLERIC, dndClass.DRUID, dndClass.WIZARD}),
    CORDONOFARROWS ("Cordon Of Arrows", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.RANGER}),
    COUNTERSPELL ("Counterspell", (byte)3, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    CREATEFOODANDWATER ("Create Food And Water", (byte)3, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.CLERIC, dndClass.PALADIN}),
    CREATEORDESTROYWATER ("Create Or Destroy Water", (byte)1, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.CLERIC, dndClass.DRUID}),
    CREATEUNDEAD ("Create Undead", (byte)6, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.CLERIC, dndClass.WARLOCK, dndClass.WIZARD}),
    CREATION ("Creation", (byte)5, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    CROWNOFMADNESS ("Crown Of Madness", (byte)2, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    CRUSADERSMANTLE ("Crusader's Mantle", (byte)3, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.PALADIN}),
    CUREWOUNDS ("Cure Wounds", (byte)1, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.DRUID, dndClass.PALADIN, dndClass.RANGER}),
    DANCINGLIGHTS ("Dancing Lights", (byte)0, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WIZARD}),
    DARKNESS ("Darkness", (byte)2, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    DARKVISION ("Darkvision", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD, dndClass.DRUID, dndClass.RANGER}),
    DAYLIGHT ("Daylight", (byte)3, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.CLERIC, dndClass.DRUID, dndClass.PALADIN, dndClass.RANGER, dndClass.SORCERER}),
    DEATHWARD ("Death Ward", (byte)4, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.CLERIC, dndClass.PALADIN}),
    DELAYEDBLASTFIREBALL ("Delayed Blast Fireball", (byte)7, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    DEMIPLANE ("Demiplane", (byte)8, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.WARLOCK, dndClass.WIZARD}),
    DESTRUCTIVEWAVE ("Destructive Wave", (byte)5, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.PALADIN}),
    DETECTEVILANDGOOD ("Detect Evil And Good", (byte)1, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.CLERIC, dndClass.PALADIN}),
    DETECTMAGIC ("Detect Magic", (byte)1, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.DRUID, dndClass.PALADIN, dndClass.RANGER, dndClass.SORCERER, dndClass.WIZARD}),
    DETECTPOISONANDDISEASE ("Detect Poison and Disease", (byte)1, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.CLERIC, dndClass.DRUID, dndClass.PALADIN, dndClass.RANGER}),
    DETECTTHOUGHTS ("Detect Thoughts", (byte)2, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WIZARD}),
    DIMENSIONDOOR ("Dimension Door", (byte)4, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    DISGUISESELF ("Disguise Self", (byte)1, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WIZARD}),
    DISINTEGRATE ("Disintegrate", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    DISPELEVILANDGOOD ("Dispel Evil and Good", (byte)5, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.CLERIC, dndClass.PALADIN}),
    DISPELMAGIC ("Dispel Magic", (byte)3, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.DRUID, dndClass.PALADIN, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    DISSONANTWHISPERS ("Dissonant Whispers", (byte)1, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD}),
    DIVINATION ("Divination", (byte)4, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.CLERIC}),
    DIVINEFAVOR ("Divine Favor", (byte)1, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.PALADIN}),
    DIVINEWORD ("Divine Word", (byte)7, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.CLERIC}),
    DOMINATEBEAST ("Dominate Beast", (byte)4, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.DRUID, dndClass.SORCERER}),
    DOMINATEMONSTER ("Dominate Monster", (byte)8, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    DOMINATEPERSON ("Dominate Person", (byte)5, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WIZARD}),
    DRAWMIJSINSTANTSUMMONS ("Drawmij's Instant Summons", (byte)6, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.WIZARD}),
    DREAM ("Dream", (byte)5, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.BARD, dndClass.WARLOCK, dndClass.WIZARD}),
    DRUIDCRAFT ("Druidcraft", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID}),
    EARTHQUAKE ("Earthquake", (byte)8, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.CLERIC, dndClass.DRUID, dndClass.SORCERER}),
    ELDRITCHBLAST ("Eldritch Blast", (byte)0, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.WARLOCK}),
    ELEMENTALWEAPON ("Elemental Weapon", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.PALADIN}),
    ENHANCEABILITY ("Enhance Ability", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.DRUID, dndClass.SORCERER}),
    ENLARGEREDUCE ("Enlarge/Reduce", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    ENSNARINGSTRIKE ("Ensnaring Strike", (byte)1, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.RANGER}),
    ENTANGLE ("Entangle", (byte)1, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID}),
    ENTHRALL ("Enthrall", (byte)2, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.WARLOCK}),
    ETHEREALNESS ("Etherealness", (byte)7, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    EVARDSBLACKTENTACLES ("Evard's Black Tentacles", (byte)4, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.WIZARD}),
    EXPEDITIOUSRETREAT ("Expeditious Retreat", (byte)1, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    EYEBITE ("Eyebite", (byte)6, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    FABRICATE ("Fabricate", (byte)4, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.WIZARD}),
    FAERIEFIRE ("Faerie Fire", (byte)1, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.BARD, dndClass.DRUID}),
    FALSELIFE ("False Life", (byte)1, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    FEAR ("Fear", (byte)3, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    FEATHERFALL ("Feather Fall", (byte)1, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WIZARD}),
    FEEBLEMIND ("Feeblemind", (byte)8, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.DRUID, dndClass.WARLOCK, dndClass.WIZARD}),
    FEIGNDEATH ("Feign Death", (byte)3, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.DRUID, dndClass.WIZARD}),
    FINDFAMILIAR ("Find Familiar", (byte)1, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.WIZARD}),
    FINDSTEED ("Find Steed", (byte)2, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.PALADIN}),
    FINDTHEPATH ("Find the Path", (byte)6, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.DRUID}),
    FINDTRAPS ("Find Traps", (byte)2, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.CLERIC, dndClass.DRUID, dndClass.RANGER}),
    FINGEROFDEATH ("Finger Of Death", (byte)7, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    FIREBALL ("Fireball", (byte)3, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    FIREBOLT ("Fire Bolt", (byte)0, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    FIRESHIELD ("Fire Shield", (byte)4, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.WIZARD}),
    FIRESTORM ("Fire Storm", (byte)7, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.CLERIC, dndClass.DRUID, dndClass.SORCERER}),
    FLAMEBLADE ("Flame Blade", (byte)2, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.DRUID}),
    FLAMESTRIKE ("Flame Strike", (byte)5, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.CLERIC}),
    FLAMINGSPHERE ("Flaming Sphere", (byte)2, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID, dndClass.WIZARD}),
    FLESHTOSTONE ("Flesh to Stone", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.WARLOCK, dndClass.WIZARD}),
    FLY ("Fly", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    FOGCLOUD ("Fog Cloud", (byte)1, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER, dndClass.SORCERER, dndClass.WIZARD}),
    FORBIDDANCE ("Forbiddance", (byte)6, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.CLERIC}),
    FORCECAGE ("Forcecage", (byte)7, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.BARD, dndClass.WARLOCK, dndClass.WIZARD}),
    FORESIGHT ("Foresight", (byte)9, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.BARD, dndClass.DRUID, dndClass.WARLOCK, dndClass.WIZARD}),
    FREEDOMOFMOVEMENT ("Freedom Of Movement", (byte)4, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.DRUID, dndClass.RANGER}),
    FRIENDS ("Friends", (byte)0, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    GASEOUSFORM ("Gaseous Form", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    GATE ("Gate", (byte)9, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.CLERIC, dndClass.SORCERER, dndClass.WIZARD}),
    GEAS ("Geas", (byte)5, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.DRUID, dndClass.PALADIN, dndClass.WIZARD}),
    GENTLEREPOSE ("Gentle Repose", (byte)2, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.CLERIC, dndClass.WIZARD}),
    GIANTINSECT ("Giant Insect", (byte)4, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID}),
    GLIBNESS ("Glibness", (byte)8, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.BARD, dndClass.WARLOCK}),
    GLOBEOFINVULNERABILITY ("Globe Of Invulnerability", (byte)6, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    GLYPHOFWARDING ("Glyph Of Warding", (byte)3, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.WIZARD}),
    GOODBERRY ("Goodberry", (byte)1, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER}),
    GRASPINGVINE ("Grasping Vine", (byte)4, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER}),
    GREASE ("Grease", (byte)1, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.WIZARD}),
    GREATERINVISIBILITY ("Greater Invisibility", (byte)4, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WIZARD}),
    GREATERRESTORATION ("Greater Restoration", (byte)5, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.DRUID}),
    GUARDIANOFFAITH ("Guardian Of Faith", (byte)4, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.CLERIC}),
    GUARDSANDWARDS ("Guards and Wards", (byte)6, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.BARD, dndClass.WIZARD}),
    GUIDANCE ("Guidance", (byte)0, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.CLERIC, dndClass.DRUID}),
    GUIDINGBOLT ("Guiding Bolt", (byte)1, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.CLERIC}),
    GUSTOFWIND ("Gust Of Wind", (byte)2, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    HAILOFTHORNS ("Hail Of Thorns", (byte)1, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.RANGER}),
    HALLOW ("Hallow", (byte)5, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.CLERIC}),
    HALLUCINATORYTERRAIN ("Hallucinatory Terrain", (byte)4, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.BARD, dndClass.DRUID, dndClass.WARLOCK, dndClass.WIZARD}),
    HARM ("Harm", (byte)6, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.CLERIC}),
    HASTE ("Haste", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    HEAL ("Heal", (byte)6, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.CLERIC, dndClass.DRUID}),
    HEALINGWORD ("Healing Word", (byte)1, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.DRUID}),
    HEATMETAL ("Heat Metal", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.BARD, dndClass.DRUID}),
    HELLISHREBUKE ("Hellish Rebuke", (byte)1, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.WARLOCK}),
    HEROESFEAST ("Heroes' Feast", (byte)6, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.CLERIC, dndClass.DRUID}),
    HEROISM ("Heroism", (byte)1, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.PALADIN}),
    HEX ("Hex", (byte)1, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.WARLOCK}),
    HOLDMONSTER ("Hold Monster", (byte)5, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    HOLDPERSON ("Hold Person", (byte)2, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.DRUID, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    HOLYAURA ("Holy Aura", (byte)8, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.CLERIC}),
    HUNGEROFHADAR ("Hunger Of Hadar", (byte)3, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.WARLOCK}),
    HUNTERSMARK ("Hunter's Mark", (byte)1, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.RANGER}),
    HYPNOTICPATTERN ("Hypnotic Pattern", (byte)3, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    ICESTORM ("Ice Storm", (byte)4, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    IDENTIFY ("Identify", (byte)1, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.BARD, dndClass.WIZARD}),
    ILLUSORYSCRIPT ("Illusory Script", (byte)1, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.BARD, dndClass.WARLOCK, dndClass.WIZARD}),
    IMPRISONMENT ("Imprisonment", (byte)9, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.WARLOCK, dndClass.WIZARD}),
    INCENDIARYCLOUD ("Incendiary Cloud", (byte)8, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    INFLICTWOUNDS ("Inflict Wounds", (byte)1, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.CLERIC}),
    INSECTPLAGUE ("Insect Plague", (byte)5, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.CLERIC, dndClass.DRUID, dndClass.SORCERER}),
    INVISIBILITY ("Invisibility", (byte)2, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    JUMP ("Jump", (byte)1, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER, dndClass.SORCERER, dndClass.WIZARD}),
    KNOCK ("Knock", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WIZARD}),
    LEGENDLORE ("Legend Lore", (byte)5, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.WIZARD}),
    LEOMUNDSSECRETCHEST ("Leomund's Secret Chest", (byte)4, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.WIZARD}),
    LEOMUNDSTINYHUT ("Leomund's Tiny Hut", (byte)3, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.BARD, dndClass.WIZARD}),
    LESSERRESTORATION ("Lesser Restoration", (byte)2, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.DRUID, dndClass.PALADIN, dndClass.RANGER}),
    LEVITATE ("Levitate", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    LIGHT ("Light", (byte)0, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.SORCERER, dndClass.WIZARD}),
    LIGHTNINGARROW ("Lightning Arrow", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.RANGER}),
    LIGHTNINGBOLT ("Lightning Bolt", (byte)3, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    LOCATEANIMALSORPLANTS ("Locate Animals or Plants", (byte)2, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.BARD, dndClass.DRUID, dndClass.RANGER}),
    LOCATECREATURE ("Locate Creature", (byte)4, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.DRUID, dndClass.PALADIN, dndClass.RANGER, dndClass.WIZARD}),
    LOCATEOBJECT ("Locate Object", (byte)2, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.DRUID, dndClass.PALADIN, dndClass.RANGER, dndClass.WIZARD}),
    LONGSTRIDER ("Longstrider", (byte)1, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.BARD, dndClass.DRUID, dndClass.RANGER, dndClass.WIZARD}),
    MAGEARMOR ("Mage Armor", (byte)1, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    MAGEHAND ("Mage Hand", (byte)0, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    MAGICCIRCLE ("Magic Circle", (byte)3, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.CLERIC, dndClass.PALADIN, dndClass.WARLOCK, dndClass.WIZARD}),
    MAGICJAR ("Magic Jar", (byte)6, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.WIZARD}),
    MAGICMISSILE ("Magic Missile", (byte)1, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    MAGICMOUTH ("Magic Mouth", (byte)2, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.BARD, dndClass.WIZARD}),
    MAGICWEAPON ("Magic Weapon", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.PALADIN, dndClass.WIZARD}),
    MAJORIMAGE ("Major Image", (byte)3, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    MASSCUREWOUNDS ("Mass Cure Wounds", (byte)5, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.DRUID}),
    MASSHEAL ("Mass Heal", (byte)9, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.CLERIC}),
    MASSHEALINGWORD ("Mass Healing Word", (byte)3, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.CLERIC}),
    MASSSUGGESTION ("Mass Suggestion", (byte)6, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    MAZE ("Maze", (byte)8, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.WIZARD}),
    MELDINTOSTONE ("Meld Into Stone", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.CLERIC, dndClass.DRUID}),
    MELFSACIDARROW ("Melf's Acid Arrow", (byte)2, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.WIZARD}),
    MENDING ("Mending", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    MESSAGE ("Message", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WIZARD}),
    METEORSWARM ("Meteor Swarm", (byte)9, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    MINDBLANK ("Mind Blank", (byte)8, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.BARD, dndClass.WIZARD}),
    MINORILLUSION ("Minor Illusion", (byte)0, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    MIRAGEARCANE ("Mirage Arcane", (byte)7, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.BARD, dndClass.DRUID, dndClass.WIZARD}),
    MIRRORIMAGE ("Mirror Image", (byte)2, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    MISLEAD ("Mislead", (byte)5, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.BARD, dndClass.WIZARD}),
    MISTYSTEP ("Misty Step", (byte)2, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    MODIFYMEMORY ("Modify Memory", (byte)5, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.WIZARD}),
    MOONBEAM ("Moonbeam", (byte)2, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.DRUID}),
    MORDENKAINENSFAITHFULHOUND ("Mordenkainen's Faithful Hound", (byte)4, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.WIZARD}),
    MORDENKAINENSMAGNIFICENTMANSION ("Mordenkainen's Magnificent Mansion", (byte)7, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.BARD, dndClass.WIZARD}),
    MORDENKAINENSPRIVATESANCTUM ("Mordenkainen's Private Sanctum", (byte)4, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.WIZARD}),
    MORDENKAINENSSWORD ("Mordenkainen's Sword", (byte)7, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.BARD, dndClass.WIZARD}),
    MOVEEARTH ("Move Earth", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    NONDETECTION ("Nondetection", (byte)3, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.BARD, dndClass.RANGER, dndClass.WIZARD}),
    NYSTULSMAGICAURA ("Nystul's Magic Aura", (byte)2, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.WIZARD}),
    OTILUKESFREEZINGSPHERE ("Otiluke's Freezing Sphere", (byte)6, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.WIZARD}),
    OTILUKESRESILIENTSPHERE ("Otiluke's Resilient Sphere", (byte)4, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.WIZARD}),
    OTTOSIRRESISTIBLEDANCE ("Otto's Irresistible Dance", (byte)6, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.WIZARD}),
    PASSWITHOUTTRACE ("Pass Without Trace", (byte)2, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER}),
    PASSWALL ("Passwall", (byte)5, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.WIZARD}),
    PHANTASMALFORCE ("Phantasmal Force", (byte)2, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WIZARD}),
    PHANTASMALKILLER ("Phantasmal Killer", (byte)4, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.WIZARD}),
    PHANTOMSTEED ("Phantom Steed", (byte)3, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.WIZARD}),
    PLANARALLY ("Planar Ally", (byte)6, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.CLERIC}),
    PLANARBINDING ("Planar Binding", (byte)5, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.DRUID, dndClass.WIZARD}),
    PLANESHIFT ("Plane Shift", (byte)7, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.CLERIC, dndClass.DRUID, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    PLANTGROWTH ("Plant Growth", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.BARD, dndClass.DRUID, dndClass.RANGER}),
    POISONSPRAY ("Poison Spray", (byte)0, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    POLYMORPH ("Polymorph", (byte)4, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.BARD, dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    POWERWORDHEAL ("Power Word Heal", (byte)9, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.BARD}),
    POWERWORDKILL ("Power Word Kill", (byte)9, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    POWERWORDSTUN ("Power Word Stun", (byte)8, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    PRAYEROFHEALING ("Prayer Of Healing", (byte)2, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.CLERIC}),
    PRESTIDIGITATION ("Prestidigitation", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    PRISMATICSPRAY ("Prismatic Spray", (byte)7, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    PRISMATICWALL ("Prismatic Wall", (byte)9, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.WIZARD}),
    PRODUCEFLAME ("Produce Flame", (byte)0, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID}),
    PROGRAMMEDILLUSION ("Programmed Illusion", (byte)6, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.BARD, dndClass.WIZARD}),
    PROJECTIMAGE ("Project Image", (byte)7, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.BARD, dndClass.WIZARD}),
    PROTECTIONFROMENERGY ("Protection From Energy", (byte)3, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.CLERIC, dndClass.DRUID, dndClass.RANGER, dndClass.SORCERER, dndClass.WIZARD}),
    PROTECTIONFROMEVILANDGOOD ("Protection From Evil and Good", (byte)1, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.CLERIC, dndClass.PALADIN, dndClass.WARLOCK, dndClass.WIZARD}),
    PROTECTIONFROMPOISON ("Protection From Poison", (byte)2, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.CLERIC, dndClass.DRUID, dndClass.PALADIN, dndClass.RANGER}),
    PURIFYFOODANDDRINK ("Purify Food And Drink", (byte)1, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.CLERIC, dndClass.DRUID, dndClass.PALADIN}),
    RAISEDEAD ("Raise Dead", (byte)5, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.PALADIN}),
    RARYSTELEPATHICBOND ("Rary's Telepathic Bond", (byte)5, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.WIZARD}),
    RAYOFENFEEBLEMENT ("Ray Of Enfeeblement", (byte)2, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.WARLOCK, dndClass.WIZARD}),
    RAYOFFROST ("Ray Of Frost", (byte)0, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    RAYOFSICKNESS ("Ray Of Sickness", (byte)1, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    REGENERATE ("Regenerate", (byte)7, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.DRUID}),
    REINCARNATE ("Reincarnate", (byte)5, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID}),
    REMOVECURSE ("Remove Curse", (byte)3, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.CLERIC, dndClass.PALADIN, dndClass.WARLOCK, dndClass.WIZARD}),
    RESISTANCE ("Resistance", (byte)0, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.CLERIC, dndClass.DRUID}),
    RESURRECTION ("Resurrection", (byte)7, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.BARD, dndClass.CLERIC}),
    REVERSEGRAVITY ("Reverse Gravity", (byte)7, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    REVIVIFY ("Revivify", (byte)3, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.CLERIC, dndClass.PALADIN}),
    ROPETRICK ("Rope Trick", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.WIZARD}),
    SACREDFLAME ("Sacred Flame", (byte)0, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.CLERIC}),
    SANCTUARY ("Sanctuary", (byte)1, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.CLERIC}),
    SCORCHINGRAY ("Scorching Ray", (byte)2, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    SCRYING ("Scrying", (byte)5, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.DRUID, dndClass.WARLOCK, dndClass.WIZARD}),
    SEARINGSMITE ("Searing Smite", (byte)1, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.PALADIN}),
    SEEINVISIBILITY ("See Invisibility", (byte)2, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WIZARD}),
    SEEMING ("Seeming", (byte)5, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WIZARD}),
    SENDING ("Sending", (byte)3, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.WIZARD}),
    SEQUESTER ("Sequester", (byte)7, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.WIZARD}),
    SHAPECHANGE ("Shapechange", (byte)9, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID, dndClass.WIZARD}),
    SHATTER ("Shatter", (byte)2, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    SHIELD ("Shield", (byte)1, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    SHIELDOFFAITH ("Shield Of Faith", (byte)1, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.CLERIC, dndClass.PALADIN}),
    SHILLELAGH ("Shillelagh", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID}),
    SHOCKINGGRASP ("Shocking Grasp", (byte)0, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    SILENCE ("Silence", (byte)2, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.RANGER}),
    SILENTIMAGE ("Silent Image", (byte)1, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WIZARD}),
    SIMULACRUM ("Simulacrum", (byte)7, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.WIZARD}),
    SLEEP ("Sleep", (byte)1, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WIZARD}),
    SLEETSTORM ("Sleet Storm", (byte)3, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    SLOW ("Slow", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    SPARETHEDYING ("Spare the Dying", (byte)0, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.CLERIC}),
    SPEAKWITHANIMALS ("Speak with Animals", (byte)1, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.BARD, dndClass.DRUID, dndClass.RANGER}),
    SPEAKWITHDEAD ("Speak with Dead", (byte)3, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.BARD, dndClass.CLERIC}),
    SPEAKWITHPLANTS ("Speak with Plants", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.BARD, dndClass.DRUID, dndClass.RANGER}),
    SPIDERCLIMB ("Spider Climb", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    SPIKEGROWTH ("Spike Growth", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER}),
    SPIRITGUARDIANS ("Spirit Guardians", (byte)3, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.CLERIC}),
    SPIRITUALWEAPON ("Spiritual Weapon", (byte)2, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.CLERIC}),
    STAGGERINGSMITE ("Staggering Smite", (byte)4, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.PALADIN}),
    STINKINGCLOUD ("Stinking Cloud", (byte)3, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WIZARD}),
    STONESHAPE ("Stone Shape", (byte)4, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.CLERIC, dndClass.DRUID, dndClass.WIZARD}),
    STONESKIN ("Stoneskin", (byte)4, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER, dndClass.SORCERER, dndClass.WIZARD}),
    STORMOFVENGEANCE ("Storm Of Vengeance", (byte)9, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID}),
    SUGGESTION ("Suggestion", (byte)2, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    SUNBEAM ("Sunbeam", (byte)6, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    SUNBURST ("Sunburst", (byte)8, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    SWIFTQUIVER ("Swift Quiver", (byte)5, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.RANGER}),
    SYMBOL ("Symbol", (byte)7, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.WIZARD}),
    TASHASHIDEOUSLAUGHTER ("Tasha's Hideous Laughter", (byte)1, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.WIZARD}),
    TELEKINESIS ("Telekinesis", (byte)5, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    TELEPATHY ("Telepathy", (byte)8, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.WIZARD}),
    TELEPORT ("Teleport", (byte)7, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WIZARD}),
    TELEPORTATIONCIRCLE ("Teleportation Circle", (byte)5, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WIZARD}),
    TENSERSFLOATINGDISK ("Tenser's Floating Disk", (byte)1, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.WIZARD}),
    THAUMATURGY ("Thaumaturgy", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.CLERIC}),
    THORNWHIP ("Thorn Whip", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID}),
    THUNDEROUSSMITE ("Thunderous Smite", (byte)1, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.PALADIN}),
    THUNDERWAVE ("Thunderwave", (byte)1, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.BARD, dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    TIMESTOP ("Time Stop", (byte)9, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    TONGUES ("Tongues", (byte)3, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    TRANSPORTVIAPLANTS ("Transport Via Plants", (byte)6, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID}),
    TREESTRIDE ("Tree Stride", (byte)5, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER}),
    TRUEPOLYMORPH ("True Polymorph", (byte)9, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.BARD, dndClass.WARLOCK, dndClass.WIZARD}),
    TRUERESURRECTION ("True Resurrection", (byte)9, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.CLERIC, dndClass.DRUID}),
    TRUESEEING ("True Seeing", (byte)6, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    TRUESTRIKE ("True Strike", (byte)0, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    TSUNAMI ("Tsunami", (byte)8, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID}),
    UNSEENSERVANT ("Unseen Servant", (byte)1, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.BARD, dndClass.WARLOCK, dndClass.WIZARD}),
    VAMPIRICTOUCH ("Vampiric Touch", (byte)3, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.WARLOCK, dndClass.WIZARD}),
    VICIOUSMOCKERY ("Vicious Mockery", (byte)0, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD}),
    WALLOFFIRE ("Wall Of Fire", (byte)4, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    WALLOFFORCE ("Wall Of Force", (byte)5, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.WIZARD}),
    WALLOFICE ("Wall Of Ice", (byte)6, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.WIZARD}),
    WALLOFSTONE ("Wall Of Stone", (byte)5, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    WALLOFTHORNS ("Wall Of Thorns", (byte)6, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID}),
    WARDINGBOND ("Warding Bond", (byte)2, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.CLERIC}),
    WATERBREATHING ("Water Breathing", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER, dndClass.SORCERER, dndClass.WIZARD}),
    WATERWALK ("Water Walk", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.CLERIC, dndClass.DRUID, dndClass.RANGER, dndClass.SORCERER}),
    WEB ("Web", (byte)2, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    WEIRD ("Weird", (byte)9, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.WIZARD}),
    WINDWALK ("Wind Walk", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID}),
    WINDWALL ("Wind Wall", (byte)3, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER}),
    WISH ("Wish", (byte)9, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    WITCHBOLT ("Witch Bolt", (byte)1, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    WORDOFRECALL ("Word Of Recall", (byte)6, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.CLERIC}),
    WRATHFULSMITE ("Wrathful Smite", (byte)1, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.PALADIN}),
    ZONEOFTRUTH ("Zone Of Truth", (byte)2, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.CLERIC, dndClass.PALADIN}),

    //Xanathar's Guide to Everything spells
    ABIDALZIMSHORRIDWILTING ("Abi-Dalzim's Horrid Wilting", (byte)8, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    ABSORBELEMENTS ("Absorb Elements", (byte)1, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER, dndClass.WIZARD, dndClass.SORCERER}),
    AGANAZZARSSCORCHER ("Aganazzar's Scorcher", (byte)2, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    BEASTBOND ("Beast Bond", (byte)1, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER}),
    BONESOFTHEEARTH ("Bones of the Earth", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID}),
    CATAPULT ("Catapult", (byte)1, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    CATNAP ("Catnap", (byte)3, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.WIZARD, dndClass.BARD, dndClass.SORCERER}),
    CAUSEFEAR ("Cause Fear", (byte)1, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.WARLOCK, dndClass.WIZARD}),
    CEREMONY ("Ceremony", (byte)1, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.CLERIC, dndClass.PALADIN}),
    CHAOSBOLT ("Chaos Bolt", (byte)1, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER}),
    CHARMMONSTER ("Charm Monster", (byte)4, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.DRUID, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    CONTROLFLAMES ("Control Flames", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    CONTROLWINDS ("Control Winds", (byte)5, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    CREATEBONFIRE ("Create Bonfire", (byte)0, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    CREATEHOMUNCULUS ("Create Homunculus", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.WIZARD}),
    CROWNOFSTARS ("Crown of Stars", (byte)7, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    DANSEMACABRE ("Danse Macabre", (byte)5, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.WARLOCK, dndClass.WIZARD}),
    DAWN ("Dawn", (byte)5, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.CLERIC, dndClass.WIZARD}),
    DRAGONSBREATH ("Dragon's Breath", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    DRUIDGROVE ("Druid Grove", (byte)6, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.DRUID}),
    DUSTDEVIL ("Dust Devil", (byte)2, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    EARTHBIND ("Earthbind", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.BARD, dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    EARTHTREMOR ("Earth Tremor", (byte)1, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    ELEMENTALBANE ("Elemental Bane", (byte)4, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID, dndClass.WIZARD, dndClass.WARLOCK}),
    ENEMIESABOUND ("Enemies Abound", (byte)3, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    ENERVATION ("Enervation", (byte)5, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    ERUPTINGEARTH ("Erupting Earth", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    FARSTEP ("Far Step", (byte)5, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    FINDGREATERSTEED ("Find Greater Steed", (byte)4, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.PALADIN}),
    FLAMEARROWS ("Flame Arrows", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER, dndClass.SORCERER, dndClass.WIZARD}),
    FROSTBITE ("Frostbite", (byte)0, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    GUARDIANOFNATURE ("Guardian of Nature", (byte)4, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER}),
    GUST ("Gust", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    HEALINGSPIRIT ("Healing Spirit", (byte)2, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER}),
    HOLYWEAPON ("Holy Weapon", (byte)5, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.CLERIC, dndClass.PALADIN}),
    ICEKNIFE ("Ice Knife", (byte)1, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    ILLUSORYDRAGON ("Illusory Dragon", (byte)8, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.WIZARD}),
    IMMOLATION ("Immolation", (byte)5, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    INFERNALCALLING ("Infernal Calling", (byte)5, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.WARLOCK, dndClass.WIZARD}),
    INFESTATION ("Infestation", (byte)0, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    INVESTITUREOFFLAME ("Investiture of Flame", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    INVESTITUREOFICE ("Investiture of Ice", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    INVESTITUREOFSTONE ("Investiture of Stone", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    INVESTITUREOFWIND ("Investiture of Wind", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    INVULNERABILITY ("Invulnerability", (byte)9, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.WIZARD}),
    LIFETRANSFERENCE ("Life Transference", (byte)3, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.CLERIC, dndClass.WIZARD}),
    MADDENINGDARKNESS ("Maddening Darkness", (byte)8, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.WARLOCK, dndClass.WIZARD}),
    MAELSTROM ("Maelstrom", (byte)5, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.DRUID}),
    MAGICSTONE ("Magic Stone", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID, dndClass.WARLOCK}),
    MASSPOLYMORPH ("Mass Polymorph", (byte)9, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD, dndClass.BARD}),
    MAXIMILIANSEARTHENGRASP ("Maximilian's Earthen Grasp", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    MELFSMINUTEMETEORS ("Melf's Minute Meteors", (byte)3, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    MENTALPRISON ("Mental Prison", (byte)6, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    MIGHTYFORTRESS ("Mighty Fortress", (byte)8, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.WIZARD}),
    MINDSPIKE ("Mind Spike", (byte)2, dndSpellSchool.DIVINATION, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    MOLDEARTH ("Mold Earth", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    NEGATIVEENERGYFLOOD ("Negative Energy Flood", (byte)5, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.WARLOCK, dndClass.WIZARD}),
    POWERWORDPAIN ("Power Word Pain", (byte)7, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    PRIMALSAVAGERY ("Primal Savagery", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID}),
    PRIMORDIALWARD ("Primordial Ward", (byte)6, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.DRUID}),
    PSYCHICSCREAM ("Psychic Scream", (byte)9, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    PYROTECHNICS ("Pyrotechnics", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WIZARD}),
    SCATTER ("Scatter", (byte)6, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    SHADOWBLADE ("Shadow Blade", (byte)2, dndSpellSchool.ILLUSION, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    SHADOWOFMOIL ("Shadow of Moil", (byte)4, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.WARLOCK}),
    SHAPEWATER ("Shape Water", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    SICKENINGRADIANCE ("Sickening Radiance", (byte)4, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    SKILLEMPOWERMENT ("Skill Empowerment", (byte)5, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WIZARD}),
    SKYWRITE ("Skywrite", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.BARD, dndClass.DRUID, dndClass.WIZARD}),
    SNARE ("Snare", (byte)1, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER, dndClass.WIZARD}),
    SNILLOCSSNOWBALLSWARM ("Snilloc's Snowball Swarm", (byte)2, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    SOULCAGE ("Soul Cage", (byte)6, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.WARLOCK, dndClass.WIZARD}),
    STEELWINDSTRIKE ("Steel Wind Strike", (byte)5, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.RANGER, dndClass.WIZARD}),
    STORMSPHERE ("Storm Sphere", (byte)4, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    SUMMONGREATERDEMON ("Summon Greater Demon", (byte)4, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.WARLOCK, dndClass.WIZARD}),
    SUMMONLESSERDEMONS ("Summon Lesser Demons", (byte)3, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.WARLOCK, dndClass.WIZARD}),
    SYNAPTICSTATIC ("Synaptic Static", (byte)5, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    TEMPLEOFTHEGODS ("Temple of the Gods", (byte)7, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.CLERIC}),
    TENSERSTRANSFORMATION ("Tenser's Transformation", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.WIZARD}),
    THUNDERCLAP ("Thunderclap", (byte)0, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.DRUID, dndClass.WARLOCK, dndClass.WIZARD}),
    THUNDERSTEP ("Thunder Step", (byte)3, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    TIDALWAVE ("Tidal Wave", (byte)3, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID, dndClass.WIZARD, dndClass.SORCERER}),
    TINYSERVANT ("Tiny Servant", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.WIZARD}),
    TOLLTHEDEAD ("Toll the Dead", (byte)0, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.WARLOCK, dndClass.WIZARD, dndClass.CLERIC}),
    TRANSMUTEROCK ("Transmute Rock", (byte)5, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.DRUID, dndClass.WIZARD}),
    VITRIOLICSPHERE ("Vitriolic Sphere", (byte)4, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    WALLOFLIGHT ("Wall of Light", (byte)5, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    WALLOFSAND ("Wall of Sand", (byte)3, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.WIZARD}),
    WALLOFWATER ("Wall of Water", (byte)3, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    WARDINGWIND ("Warding Wind", (byte)2, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.BARD, dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    WATERYSPHERE ("Watery Sphere", (byte)4, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID, dndClass.SORCERER, dndClass.WIZARD}),
    WHIRLWIND ("Whirlwind", (byte)7, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.DRUID, dndClass.WIZARD, dndClass.SORCERER}),
    WORDOFRADIANCE ("Word of Radiance", (byte)0, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.CLERIC}),
    WRATHOFNATURE ("Wrath of Nature", (byte)5, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER}),
    ZEPHYRSTRIKE ("Zephyr Strike", (byte)1, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.RANGER}),

    //Tasha's
    BLADEOFDISASTER ("Blade of Disaster", (byte)9, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    BOOMINGBLADE ("Booming Blade", (byte)0, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.ARTIFICER, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    DREAMOFTHEBLUEVEIL ("Dream of the Blue Veil", (byte)7, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    GREENFLAMEBLADE ("Green-Flame Blade", (byte)0, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.ARTIFICER, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    INTELLECTFORTRESS ("Intellect Fortress", (byte)3, dndSpellSchool.ABJURATION, new dndClass[]{dndClass.ARTIFICER, dndClass.BARD, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    LIGHTNINGLURE ("Lightning Lure", (byte)0, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.ARTIFICER, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    MINDSLIVER ("Mind Sliver", (byte)0, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    SPIRITSHROUD ("Spirit Shroud", (byte)3, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.CLERIC, dndClass.PALADIN, dndClass.WARLOCK, dndClass.WIZARD}),
    SUMMONABERRATION ("Summon Aberration", (byte)4, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.WARLOCK, dndClass.WIZARD}),
    SUMMONBEAST ("Summon Beast", (byte)2, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER}),
    SUMMONCELESTIAL ("Summon Celestial", (byte)5, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.CLERIC, dndClass.PALADIN}),
    SUMMONCONSTRUCT ("Summon Construct", (byte)4, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.ARTIFICER, dndClass.WIZARD}),
    SUMMONELEMENTAL ("Summon Elemental", (byte)4, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER, dndClass.WIZARD}),
    SUMMONFEY ("Summon Fey", (byte)3, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.DRUID, dndClass.RANGER, dndClass.WARLOCK, dndClass.WIZARD}),
    SUMMONFIEND ("Summon Fiend", (byte)6, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.WARLOCK, dndClass.WIZARD}),
    SUMMONSHADOWSPAWN ("Summon Shadowspawn", (byte)3, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.WARLOCK, dndClass.WIZARD}),
    SUMMONUNDEAD ("Summon Undead", (byte)3, dndSpellSchool.NECROMANCY, new dndClass[]{dndClass.WARLOCK, dndClass.WIZARD}),
    SWORDBURST ("Sword Burst", (byte)0, dndSpellSchool.CONJURATION, new dndClass[]{dndClass.ARTIFICER, dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD}),
    TASHASCAUSTICBREW ("Tasha's Caustic Brew", (byte)1, dndSpellSchool.EVOCATION, new dndClass[]{dndClass.ARTIFICER, dndClass.SORCERER, dndClass.WIZARD}),
    TASHASMINDWHIP ("Tasha's Mind Whip", (byte)2, dndSpellSchool.ENCHANTMENT, new dndClass[]{dndClass.SORCERER, dndClass.WIZARD}),
    TASHASOTHERWORLDLYGUISE ("Tasha's Otherworldly Guise", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClass[]{dndClass.SORCERER, dndClass.WARLOCK, dndClass.WIZARD});

    /**
     * A member field storing the spells fully formatted name used for text output to the user
     */
    private final String spellName;
    /**
     * A member field storing the spells level
     */
    private final byte level;
    /**
     * A member field storing the spells school
     */
    private final dndSpellSchool school;
    /**
     * A member field hashset storing all classes this spell can be used by
     */
    private final HashSet<dndClass> classes = new HashSet<>();
    /**
     * A static member field storing how many spells there are
     */
    private static final int size = dndSpell.values().length;
    /**
     * A static member field storing a list of all spells values. Uppercase, letters only.
     */
    private static final HashSet<String> validFormattedNames = new HashSet<String>();     //A HashSet of the valid spell names. Uppercase only.
    static{
        for(dndSpell name : EnumSet.allOf(dndSpell.class))
            validFormattedNames.add(name.name());
    }

    /**
     * Constructor for the dndSpell enum
     * @param spellName The fully punctuated and formatted name of the spell
     * @param level The level of the spell
     * @param school The school the spell belongs to
     * @param classes An array of all classes this spell can be used by
     */
    dndSpell(final String spellName, final byte level, final dndSpellSchool school, final dndClass[] classes) {
        this.spellName = spellName;
        this.level = level;
        this.school = school;
        for(dndClass cl : classes)    //Transferring the array of classes passed in the constructor into a HashSet for quicker lookup time.
            this.classes.add(cl);
    }

    /**
     * Overriding the toString function to return the properly punctuated spell name
     * @return A string that is the fully punctuated spell name
     */
    @Override   
    public String toString()
    {
        return spellName;
    }

    /**
     * A Comparator class used to sort spells based on String comparison
     */
    static class spellSorter implements Comparator<dndSpell>
    {
        /**
         * Overriden compare method that uses String.compareTo(String)
         * @param a The first spell to compare with
         * @param b The spell to compare against
         * @return The value returned by String.compareTo(String)
         */
        @Override
        public int compare(dndSpell a, dndSpell b)
        {
            return a.toString().compareTo(b.toString());
        }
    }

    /**
     * Checks if the provided String is contained in the Enum
     * @param searchForSpell The name of the spell to check for
     * @return A boolean value, true if the String is a valid spell name and false otherwise
     * @throws IllegalArgumentException
     */
    protected static boolean isValid(final String searchForSpell)       //Tests against validSpellNames HashSet and returns true if present. Throws exception if any non-uppercase characters are present
    {
        //TODO: Check for any non uppercase letters, not for all
        if(searchForSpell.replaceAll("[^A-Z]","").length() == 0)
            throw new IllegalArgumentException();
        return validFormattedNames.contains(searchForSpell);
    }
    /**
     * Returns the level of this spell
     * @return A byte representing the level of this spell
     */
    protected byte getLevel() {
        return level;
    }
    /**
     * Returns a dndSpellSchool enum value which is the school this spell belongs to
     * @return A dndSpellSchool enum value which is the school this spell belongs to
     */
    protected dndSpellSchool getSchool() {
        return school;
    }
    /**
     * Returns a set of dndClass that can use this spell
     * @return A Set containing all dndClass that can use this spell
     */
    protected Set<dndClass> getSpellClasses() {
        return Collections.unmodifiableSet(classes);
    }
    /**
     * Returns how many spells are in the enum
     * @return An integer representing the number of spells in the enum
     */
    protected int getSize() {
        return size;
    }
}
