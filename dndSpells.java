import java.util.*;

/**
 * An Enum that represents all valid spells the bot knows.
 * Each value contains a formatted name, spell level, spell school, and a HashSet of the classes that can use it
 */
public enum dndSpells {
    //PHB Spells
    ACIDSPLASH ("Acid Splash", (byte)0, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    AID ("Aid", (byte)2, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.PALADIN}),
    ALARM ("Alarm", (byte)1, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.RANGER, dndClasses.WIZARD}),
    ALTERSELF ("Alter Self", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    ANIMALFRIENDSHIP ("Animal Friendship", (byte)1, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.DRUID, dndClasses.RANGER}),
    ANIMALMESSENGER ("Animal Messenger", (byte)2, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARBARIAN, dndClasses.DRUID, dndClasses.RANGER}),
    ANIMALSHAPES ("Animal Shapes", (byte)8, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID}),
    ANIMATEDEAD ("Animate Dead", (byte)3, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.CLERIC, dndClasses.WIZARD}),
    ANIMATEOBJECTS ("Animate Objects", (byte)5, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WIZARD}),
    ANTILIFESHELL ("Antilife Shell", (byte)5, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.DRUID}),
    ANTIMAGICFIELD ("Antimagic Field", (byte)8, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.WIZARD}),
    ANTIPATHYSYMPATHY ("Antipathy/Sympathy", (byte)8, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.DRUID, dndClasses.WIZARD}),
    ARCANEEYE ("Arcane Eye", (byte)4, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.WIZARD}),
    ARCANEGATE ("Arcane Gate", (byte)6, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    ARCANELOCK ("Arcane Lock", (byte)2, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.WIZARD}),
    ARMOROFAGATHYS ("Armor Of Agathys", (byte)1, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.WARLOCK}),
    ARMSOFHADAR ("Arms Of Hadar", (byte)1, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.WARLOCK}),
    ASTRALPROJECTION ("Astral Projection", (byte)9, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.CLERIC, dndClasses.WARLOCK, dndClasses.WIZARD}),
    AUGURY ("Augury", (byte)2, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.CLERIC}),
    AURAOFLIFE ("Aura Of Life", (byte)4, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.PALADIN}),
    AURAOFPURITY ("Aura Of Purity", (byte)4, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.PALADIN}),
    AURAOFVITALITY ("Aura Of Vitality", (byte)3, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.PALADIN}),
    AWAKEN ("Awaken", (byte)5, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.BARD, dndClasses.DRUID}),
    BANE ("Bane", (byte)1, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC}),
    BANISHINGSMITE ("Banishing Smite", (byte)5, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.PALADIN}),
    BANISHMENT ("Banishment", (byte)4, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.PALADIN, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    BARKSKIN ("Barkskin", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER}),
    BEACONOFHOPE ("Beacon Of Hope", (byte)3, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.CLERIC}),
    BEASTSENSE ("Beast Sense", (byte)2, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER}),
    BESTOWCURSE ("Bestow Curse", (byte)3, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.WIZARD}),
    BIGBYSHAND ("Bigby's Hand", (byte)5, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.WIZARD}),
    BLADEBARRIER ("Blade Barrier", (byte)6, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.CLERIC}),
    BLADEWARD ("Blade Ward", (byte)0, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    BLESS ("Bless", (byte)1, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.CLERIC, dndClasses.PALADIN}),
    BLIGHT ("Blight", (byte)4, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    BLINDINGSMITE ("Blinding Smite", (byte)3, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.PALADIN}),
    BLINDNESSDEAFNESS ("Blindness/Deafness", (byte)2, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.SORCERER, dndClasses.WIZARD}),
    BLINK ("Blink", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    BLUR ("Blur", (byte)2, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    BRANDINGSMITE ("Branding Smite", (byte)2, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.PALADIN}),
    BURNINGHANDS ("Burning Hands", (byte)1, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    CALLLIGHTNING ("Call Lightning", (byte)3, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID}),
    CALMEMOTIONS ("Calm Emotions", (byte)2, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC}),
    CHAINLIGHTNING ("Chain Lightning", (byte)6, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    CHARMPERSON ("Charm Person", (byte)1, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    CHILLTOUCH ("Chill Touch", (byte)0, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    CHROMATICORB ("Chromatic Orb", (byte)1, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    CIRCLEOFDEATH ("Circle Of Death", (byte)6, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    CIRCLEOFPOWER ("Circle Of Power", (byte)5, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.PALADIN}),
    CLAIRVOYANCE ("Clairvoyance", (byte)3, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.SORCERER, dndClasses.WIZARD}),
    CLONE ("Clone", (byte)8, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.WIZARD}),
    CLOUDOFDAGGERS ("Cloud Of Daggers", (byte)2, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    CLOUDKILL ("Cloudkill", (byte)5, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    COLORSPRAY ("Color Spray", (byte)1, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    COMMAND ("Command", (byte)1, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.CLERIC, dndClasses.PALADIN}),
    COMMUNE ("Commune", (byte)5, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.CLERIC}),
    COMMUNEWITHNATURE ("Commune with Nature", (byte)5, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER}),
    COMPELLEDDUEL ("Compelled Duel", (byte)1, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.PALADIN}),
    COMPREHENDLANGUAGES ("Comprehend Languages", (byte)1, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    COMPULSION ("Compulsion", (byte)4, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD}),
    CONEOFCOLD ("Cone Of Cold", (byte)5, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    CONFUSION ("Confusion", (byte)4, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    CONJUREANIMALS ("Conjure Animals", (byte)3, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER}),
    CONJUREBARRAGE ("Conjure Barrage", (byte)3, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.RANGER}),
    CONJURECELESTIAL ("Conjure Celestial", (byte)7, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.CLERIC}),
    CONJUREELEMENTAL ("Conjure Elemental", (byte)5, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.WIZARD}),
    CONJUREFEY ("Conjure Fey", (byte)6, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.WARLOCK}),
    CONJUREMINORELEMENTALS ("Conjure Minor Elementals", (byte)4, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.WIZARD}),
    CONJUREVOLLEY ("Conjure Volley", (byte)5, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.RANGER}),
    CONJUREWOODLANDBEINGS ("Conjure Woodland Beings", (byte)4, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER}),
    CONTACTOTHERPLANE ("Contact Other Plane", (byte)5, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.WARLOCK, dndClasses.WIZARD}),
    CONTAGION ("Contagion", (byte)5, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.CLERIC, dndClasses.DRUID}),
    CONTINGENCY ("Contingency", (byte)6, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.WIZARD}),
    CONTINUALFLAME ("Continual Flame", (byte)2, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.WIZARD}),
    CONTROLWATER ("Control Water", (byte)4, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.DRUID, dndClasses.WIZARD}),
    CONTROLWEATHER ("Control Weather", (byte)8, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.DRUID, dndClasses.WIZARD}),
    CORDONOFARROWS ("Cordon Of Arrows", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.RANGER}),
    COUNTERSPELL ("Counterspell", (byte)3, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    CREATEFOODANDWATER ("Create Food And Water", (byte)3, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.PALADIN}),
    CREATEORDESTROYWATER ("Create Or Destroy Water", (byte)1, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.DRUID}),
    CREATEUNDEAD ("Create Undead", (byte)6, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.CLERIC, dndClasses.WARLOCK, dndClasses.WIZARD}),
    CREATION ("Creation", (byte)5, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    CROWNOFMADNESS ("Crown Of Madness", (byte)2, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    CRUSADERSMANTLE ("Crusader's Mantle", (byte)3, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.PALADIN}),
    CUREWOUNDS ("Cure Wounds", (byte)1, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.DRUID, dndClasses.PALADIN, dndClasses.RANGER}),
    DANCINGLIGHTS ("Dancing Lights", (byte)0, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WIZARD}),
    DARKNESS ("Darkness", (byte)2, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    DARKVISION ("Darkvision", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD, dndClasses.DRUID, dndClasses.RANGER}),
    DAYLIGHT ("Daylight", (byte)3, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.DRUID, dndClasses.PALADIN, dndClasses.RANGER, dndClasses.SORCERER}),
    DEATHWARD ("Death Ward", (byte)4, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.PALADIN}),
    DELAYEDBLASTFIREBALL ("Delayed Blast Fireball", (byte)7, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    DEMIPLANE ("Demiplane", (byte)8, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.WARLOCK, dndClasses.WIZARD}),
    DESTRUCTIVEWAVE ("Destructive Wave", (byte)5, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.PALADIN}),
    DETECTEVILANDGOOD ("Detect Evil And Good", (byte)1, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.PALADIN}),
    DETECTMAGIC ("Detect Magic", (byte)1, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.DRUID, dndClasses.PALADIN, dndClasses.RANGER, dndClasses.SORCERER, dndClasses.WIZARD}),
    DETECTPOISONANDDISEASE ("Detect Poison and Disease", (byte)1, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.DRUID, dndClasses.PALADIN, dndClasses.RANGER}),
    DETECTTHOUGHTS ("Detect Thoughts", (byte)2, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WIZARD}),
    DIMENSIONDOOR ("Dimension Door", (byte)4, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    DISGUISESELF ("Disguise Self", (byte)1, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WIZARD}),
    DISINTEGRATE ("Disintegrate", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    DISPELEVILANDGOOD ("Dispel Evil and Good", (byte)5, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.PALADIN}),
    DISPELMAGIC ("Dispel Magic", (byte)3, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.DRUID, dndClasses.PALADIN, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    DISSONANTWHISPERS ("Dissonant Whispers", (byte)1, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD}),
    DIVINATION ("Divination", (byte)4, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.CLERIC}),
    DIVINEFAVOR ("Divine Favor", (byte)1, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.PALADIN}),
    DIVINEWORD ("Divine Word", (byte)7, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.CLERIC}),
    DOMINATEBEAST ("Dominate Beast", (byte)4, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER}),
    DOMINATEMONSTER ("Dominate Monster", (byte)8, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    DOMINATEPERSON ("Dominate Person", (byte)5, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WIZARD}),
    DRAWMIJSINSTANTSUMMONS ("Drawmij's Instant Summons", (byte)6, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.WIZARD}),
    DREAM ("Dream", (byte)5, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.BARD, dndClasses.WARLOCK, dndClasses.WIZARD}),
    DRUIDCRAFT ("Druidcraft", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID}),
    EARTHQUAKE ("Earthquake", (byte)8, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.DRUID, dndClasses.SORCERER}),
    ELDRITCHBLAST ("Eldritch Blast", (byte)0, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.WARLOCK}),
    ELEMENTALWEAPON ("Elemental Weapon", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.PALADIN}),
    ENHANCEABILITY ("Enhance Ability", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.DRUID, dndClasses.SORCERER}),
    ENLARGEREDUCE ("Enlarge/Reduce", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    ENSNARINGSTRIKE ("Ensnaring Strike", (byte)1, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.RANGER}),
    ENTANGLE ("Entangle", (byte)1, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID}),
    ENTHRALL ("Enthrall", (byte)2, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.WARLOCK}),
    ETHEREALNESS ("Etherealness", (byte)7, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    EVARDSBLACKTENTACLES ("Evard's Black Tentacles", (byte)4, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.WIZARD}),
    EXPEDITIOUSRETREAT ("Expeditious Retreat", (byte)1, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    EYEBITE ("Eyebite", (byte)6, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    FABRICATE ("Fabricate", (byte)4, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.WIZARD}),
    FAERIEFIRE ("Faerie Fire", (byte)1, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.BARD, dndClasses.DRUID}),
    FALSELIFE ("False Life", (byte)1, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    FEAR ("Fear", (byte)3, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    FEATHERFALL ("Feather Fall", (byte)1, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WIZARD}),
    FEEBLEMIND ("Feeblemind", (byte)8, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.DRUID, dndClasses.WARLOCK, dndClasses.WIZARD}),
    FEIGNDEATH ("Feign Death", (byte)3, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.DRUID, dndClasses.WIZARD}),
    FINDFAMILIAR ("Find Familiar", (byte)1, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.WIZARD}),
    FINDSTEED ("Find Steed", (byte)2, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.PALADIN}),
    FINDTHEPATH ("Find the Path", (byte)6, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.DRUID}),
    FINDTRAPS ("Find Traps", (byte)2, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.DRUID, dndClasses.RANGER}),
    FINGEROFDEATH ("Finger Of Death", (byte)7, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    FIREBALL ("Fireball", (byte)3, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    FIREBOLT ("Fire Bolt", (byte)0, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    FIRESHIELD ("Fire Shield", (byte)4, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.WIZARD}),
    FIRESTORM ("Fire Storm", (byte)7, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.DRUID, dndClasses.SORCERER}),
    FLAMEBLADE ("Flame Blade", (byte)2, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.DRUID}),
    FLAMESTRIKE ("Flame Strike", (byte)5, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.CLERIC}),
    FLAMINGSPHERE ("Flaming Sphere", (byte)2, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.WIZARD}),
    FLESHTOSTONE ("Flesh to Stone", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.WARLOCK, dndClasses.WIZARD}),
    FLY ("Fly", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    FOGCLOUD ("Fog Cloud", (byte)1, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER, dndClasses.SORCERER, dndClasses.WIZARD}),
    FORBIDDANCE ("Forbiddance", (byte)6, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.CLERIC}),
    FORCECAGE ("Forcecage", (byte)7, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.BARD, dndClasses.WARLOCK, dndClasses.WIZARD}),
    FORESIGHT ("Foresight", (byte)9, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.BARD, dndClasses.DRUID, dndClasses.WARLOCK, dndClasses.WIZARD}),
    FREEDOMOFMOVEMENT ("Freedom Of Movement", (byte)4, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.DRUID, dndClasses.RANGER}),
    FRIENDS ("Friends", (byte)0, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    GASEOUSFORM ("Gaseous Form", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    GATE ("Gate", (byte)9, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.SORCERER, dndClasses.WIZARD}),
    GEAS ("Geas", (byte)5, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.DRUID, dndClasses.PALADIN, dndClasses.WIZARD}),
    GENTLEREPOSE ("Gentle Repose", (byte)2, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.CLERIC, dndClasses.WIZARD}),
    GIANTINSECT ("Giant Insect", (byte)4, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID}),
    GLIBNESS ("Glibness", (byte)8, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.BARD, dndClasses.WARLOCK}),
    GLOBEOFINVULNERABILITY ("Globe Of Invulnerability", (byte)6, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    GLYPHOFWARDING ("Glyph Of Warding", (byte)3, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.WIZARD}),
    GOODBERRY ("Goodberry", (byte)1, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER}),
    GRASPINGVINE ("Grasping Vine", (byte)4, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER}),
    GREASE ("Grease", (byte)1, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.WIZARD}),
    GREATERINVISIBILITY ("Greater Invisibility", (byte)4, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WIZARD}),
    GREATERRESTORATION ("Greater Restoration", (byte)5, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.DRUID}),
    GUARDIANOFFAITH ("Guardian Of Faith", (byte)4, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.CLERIC}),
    GUARDSANDWARDS ("Guards and Wards", (byte)6, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.BARD, dndClasses.WIZARD}),
    GUIDANCE ("Guidance", (byte)0, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.DRUID}),
    GUIDINGBOLT ("Guiding Bolt", (byte)1, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.CLERIC}),
    GUSTOFWIND ("Gust Of Wind", (byte)2, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    HAILOFTHORNS ("Hail Of Thorns", (byte)1, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.RANGER}),
    HALLOW ("Hallow", (byte)5, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.CLERIC}),
    HALLUCINATORYTERRAIN ("Hallucinatory Terrain", (byte)4, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.BARD, dndClasses.DRUID, dndClasses.WARLOCK, dndClasses.WIZARD}),
    HARM ("Harm", (byte)6, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.CLERIC}),
    HASTE ("Haste", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    HEAL ("Heal", (byte)6, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.DRUID}),
    HEALINGWORD ("Healing Word", (byte)1, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.DRUID}),
    HEATMETAL ("Heat Metal", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.BARD, dndClasses.DRUID}),
    HELLISHREBUKE ("Hellish Rebuke", (byte)1, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.WARLOCK}),
    HEROESFEAST ("Heroes' Feast", (byte)6, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.DRUID}),
    HEROISM ("Heroism", (byte)1, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.PALADIN}),
    HEX ("Hex", (byte)1, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.WARLOCK}),
    HOLDMONSTER ("Hold Monster", (byte)5, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    HOLDPERSON ("Hold Person", (byte)2, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    HOLYAURA ("Holy Aura", (byte)8, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.CLERIC}),
    HUNGEROFHADAR ("Hunger Of Hadar", (byte)3, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.WARLOCK}),
    HUNTERSMARK ("Hunter's Mark", (byte)1, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.RANGER}),
    HYPNOTICPATTERN ("Hypnotic Pattern", (byte)3, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    ICESTORM ("Ice Storm", (byte)4, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    IDENTIFY ("Identify", (byte)1, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.BARD, dndClasses.WIZARD}),
    ILLUSORYSCRIPT ("Illusory Script", (byte)1, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.BARD, dndClasses.WARLOCK, dndClasses.WIZARD}),
    IMPRISONMENT ("Imprisonment", (byte)9, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.WARLOCK, dndClasses.WIZARD}),
    INCENDIARYCLOUD ("Incendiary Cloud", (byte)8, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    INFLICTWOUNDS ("Inflict Wounds", (byte)1, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.CLERIC}),
    INSECTPLAGUE ("Insect Plague", (byte)5, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.DRUID, dndClasses.SORCERER}),
    INVISIBILITY ("Invisibility", (byte)2, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    JUMP ("Jump", (byte)1, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER, dndClasses.SORCERER, dndClasses.WIZARD}),
    KNOCK ("Knock", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WIZARD}),
    LEGENDLORE ("Legend Lore", (byte)5, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.WIZARD}),
    LEOMUNDSSECRETCHEST ("Leomund's Secret Chest", (byte)4, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.WIZARD}),
    LEOMUNDSTINYHUT ("Leomund's Tiny Hut", (byte)3, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.BARD, dndClasses.WIZARD}),
    LESSERRESTORATION ("Lesser Restoration", (byte)2, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.DRUID, dndClasses.PALADIN, dndClasses.RANGER}),
    LEVITATE ("Levitate", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    LIGHT ("Light", (byte)0, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.SORCERER, dndClasses.WIZARD}),
    LIGHTNINGARROW ("Lightning Arrow", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.RANGER}),
    LIGHTNINGBOLT ("Lightning Bolt", (byte)3, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    LOCATEANIMALSORPLANTS ("Locate Animals or Plants", (byte)2, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.BARD, dndClasses.DRUID, dndClasses.RANGER}),
    LOCATECREATURE ("Locate Creature", (byte)4, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.DRUID, dndClasses.PALADIN, dndClasses.RANGER, dndClasses.WIZARD}),
    LOCATEOBJECT ("Locate Object", (byte)2, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.DRUID, dndClasses.PALADIN, dndClasses.RANGER, dndClasses.WIZARD}),
    LONGSTRIDER ("Longstrider", (byte)1, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.BARD, dndClasses.DRUID, dndClasses.RANGER, dndClasses.WIZARD}),
    MAGEARMOR ("Mage Armor", (byte)1, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    MAGEHAND ("Mage Hand", (byte)0, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    MAGICCIRCLE ("Magic Circle", (byte)3, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.PALADIN, dndClasses.WARLOCK, dndClasses.WIZARD}),
    MAGICJAR ("Magic Jar", (byte)6, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.WIZARD}),
    MAGICMISSILE ("Magic Missile", (byte)1, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    MAGICMOUTH ("Magic Mouth", (byte)2, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.BARD, dndClasses.WIZARD}),
    MAGICWEAPON ("Magic Weapon", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.PALADIN, dndClasses.WIZARD}),
    MAJORIMAGE ("Major Image", (byte)3, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    MASSCUREWOUNDS ("Mass Cure Wounds", (byte)5, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.DRUID}),
    MASSHEAL ("Mass Heal", (byte)9, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.CLERIC}),
    MASSHEALINGWORD ("Mass Healing Word", (byte)3, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.CLERIC}),
    MASSSUGGESTION ("Mass Suggestion", (byte)6, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    MAZE ("Maze", (byte)8, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.WIZARD}),
    MELDINTOSTONE ("Meld Into Stone", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.DRUID}),
    MELFSACIDARROW ("Melf's Acid Arrow", (byte)2, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.WIZARD}),
    MENDING ("Mending", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    MESSAGE ("Message", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WIZARD}),
    METEORSWARM ("Meteor Swarm", (byte)9, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    MINDBLANK ("Mind Blank", (byte)8, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.BARD, dndClasses.WIZARD}),
    MINORILLUSION ("Minor Illusion", (byte)0, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    MIRAGEARCANE ("Mirage Arcane", (byte)7, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.BARD, dndClasses.DRUID, dndClasses.WIZARD}),
    MIRRORIMAGE ("Mirror Image", (byte)2, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    MISLEAD ("Mislead", (byte)5, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.BARD, dndClasses.WIZARD}),
    MISTYSTEP ("Misty Step", (byte)2, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    MODIFYMEMORY ("Modify Memory", (byte)5, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.WIZARD}),
    MOONBEAM ("Moonbeam", (byte)2, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.DRUID}),
    MORDENKAINENSFAITHFULHOUND ("Mordenkainen's Faithful Hound", (byte)4, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.WIZARD}),
    MORDENKAINENSMAGNIFICENTMANSION ("Mordenkainen's Magnificent Mansion", (byte)7, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.BARD, dndClasses.WIZARD}),
    MORDENKAINENSPRIVATESANCTUM ("Mordenkainen's Private Sanctum", (byte)4, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.WIZARD}),
    MORDENKAINENSSWORD ("Mordenkainen's Sword", (byte)7, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.BARD, dndClasses.WIZARD}),
    MOVEEARTH ("Move Earth", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    NONDETECTION ("Nondetection", (byte)3, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.BARD, dndClasses.RANGER, dndClasses.WIZARD}),
    NYSTULSMAGICAURA ("Nystul's Magic Aura", (byte)2, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.WIZARD}),
    OTILUKESFREEZINGSPHERE ("Otiluke's Freezing Sphere", (byte)6, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.WIZARD}),
    OTILUKESRESILIENTSPHERE ("Otiluke's Resilient Sphere", (byte)4, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.WIZARD}),
    OTTOSIRRESISTIBLEDANCE ("Otto's Irresistible Dance", (byte)6, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.WIZARD}),
    PASSWITHOUTTRACE ("Pass Without Trace", (byte)2, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER}),
    PASSWALL ("Passwall", (byte)5, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.WIZARD}),
    PHANTASMALFORCE ("Phantasmal Force", (byte)2, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WIZARD}),
    PHANTASMALKILLER ("Phantasmal Killer", (byte)4, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.WIZARD}),
    PHANTOMSTEED ("Phantom Steed", (byte)3, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.WIZARD}),
    PLANARALLY ("Planar Ally", (byte)6, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.CLERIC}),
    PLANARBINDING ("Planar Binding", (byte)5, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.DRUID, dndClasses.WIZARD}),
    PLANESHIFT ("Plane Shift", (byte)7, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    PLANTGROWTH ("Plant Growth", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.BARD, dndClasses.DRUID, dndClasses.RANGER}),
    POISONSPRAY ("Poison Spray", (byte)0, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    POLYMORPH ("Polymorph", (byte)4, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.BARD, dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    POWERWORDHEAL ("Power Word Heal", (byte)9, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.BARD}),
    POWERWORDKILL ("Power Word Kill", (byte)9, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    POWERWORDSTUN ("Power Word Stun", (byte)8, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    PRAYEROFHEALING ("Prayer Of Healing", (byte)2, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.CLERIC}),
    PRESTIDIGITATION ("Prestidigitation", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    PRISMATICSPRAY ("Prismatic Spray", (byte)7, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    PRISMATICWALL ("Prismatic Wall", (byte)9, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.WIZARD}),
    PRODUCEFLAME ("Produce Flame", (byte)0, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID}),
    PROGRAMMEDILLUSION ("Programmed Illusion", (byte)6, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.BARD, dndClasses.WIZARD}),
    PROJECTIMAGE ("Project Image", (byte)7, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.BARD, dndClasses.WIZARD}),
    PROTECTIONFROMENERGY ("Protection From Energy", (byte)3, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.DRUID, dndClasses.RANGER, dndClasses.SORCERER, dndClasses.WIZARD}),
    PROTECTIONFROMEVILANDGOOD ("Protection From Evil and Good", (byte)1, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.PALADIN, dndClasses.WARLOCK, dndClasses.WIZARD}),
    PROTECTIONFROMPOISON ("Protection From Poison", (byte)2, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.DRUID, dndClasses.PALADIN, dndClasses.RANGER}),
    PURIFYFOODANDDRINK ("Purify Food And Drink", (byte)1, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.DRUID, dndClasses.PALADIN}),
    RAISEDEAD ("Raise Dead", (byte)5, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.PALADIN}),
    RARYSTELEPATHICBOND ("Rary's Telepathic Bond", (byte)5, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.WIZARD}),
    RAYOFENFEEBLEMENT ("Ray Of Enfeeblement", (byte)2, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.WARLOCK, dndClasses.WIZARD}),
    RAYOFFROST ("Ray Of Frost", (byte)0, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    RAYOFSICKNESS ("Ray Of Sickness", (byte)1, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    REGENERATE ("Regenerate", (byte)7, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.DRUID}),
    REINCARNATE ("Reincarnate", (byte)5, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID}),
    REMOVECURSE ("Remove Curse", (byte)3, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.PALADIN, dndClasses.WARLOCK, dndClasses.WIZARD}),
    RESISTANCE ("Resistance", (byte)0, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.DRUID}),
    RESURRECTION ("Resurrection", (byte)7, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC}),
    REVERSEGRAVITY ("Reverse Gravity", (byte)7, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    REVIVIFY ("Revivify", (byte)3, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.CLERIC, dndClasses.PALADIN}),
    ROPETRICK ("Rope Trick", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.WIZARD}),
    SACREDFLAME ("Sacred Flame", (byte)0, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.CLERIC}),
    SANCTUARY ("Sanctuary", (byte)1, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.CLERIC}),
    SCORCHINGRAY ("Scorching Ray", (byte)2, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    SCRYING ("Scrying", (byte)5, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.DRUID, dndClasses.WARLOCK, dndClasses.WIZARD}),
    SEARINGSMITE ("Searing Smite", (byte)1, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.PALADIN}),
    SEEINVISIBILITY ("See Invisibility", (byte)2, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WIZARD}),
    SEEMING ("Seeming", (byte)5, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WIZARD}),
    SENDING ("Sending", (byte)3, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.WIZARD}),
    SEQUESTER ("Sequester", (byte)7, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.WIZARD}),
    SHAPECHANGE ("Shapechange", (byte)9, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID, dndClasses.WIZARD}),
    SHATTER ("Shatter", (byte)2, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    SHIELD ("Shield", (byte)1, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    SHIELDOFFAITH ("Shield Of Faith", (byte)1, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.PALADIN}),
    SHILLELAGH ("Shillelagh", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID}),
    SHOCKINGGRASP ("Shocking Grasp", (byte)0, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    SILENCE ("Silence", (byte)2, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.RANGER}),
    SILENTIMAGE ("Silent Image", (byte)1, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WIZARD}),
    SIMULACRUM ("Simulacrum", (byte)7, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.WIZARD}),
    SLEEP ("Sleep", (byte)1, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WIZARD}),
    SLEETSTORM ("Sleet Storm", (byte)3, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    SLOW ("Slow", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    SPARETHEDYING ("Spare the Dying", (byte)0, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.CLERIC}),
    SPEAKWITHANIMALS ("Speak with Animals", (byte)1, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.BARD, dndClasses.DRUID, dndClasses.RANGER}),
    SPEAKWITHDEAD ("Speak with Dead", (byte)3, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC}),
    SPEAKWITHPLANTS ("Speak with Plants", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.BARD, dndClasses.DRUID, dndClasses.RANGER}),
    SPIDERCLIMB ("Spider Climb", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    SPIKEGROWTH ("Spike Growth", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER}),
    SPIRITGUARDIANS ("Spirit Guardians", (byte)3, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.CLERIC}),
    SPIRITUALWEAPON ("Spiritual Weapon", (byte)2, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.CLERIC}),
    STAGGERINGSMITE ("Staggering Smite", (byte)4, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.PALADIN}),
    STINKINGCLOUD ("Stinking Cloud", (byte)3, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WIZARD}),
    STONESHAPE ("Stone Shape", (byte)4, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.DRUID, dndClasses.WIZARD}),
    STONESKIN ("Stoneskin", (byte)4, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER, dndClasses.SORCERER, dndClasses.WIZARD}),
    STORMOFVENGEANCE ("Storm Of Vengeance", (byte)9, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID}),
    SUGGESTION ("Suggestion", (byte)2, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    SUNBEAM ("Sunbeam", (byte)6, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    SUNBURST ("Sunburst", (byte)8, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    SWIFTQUIVER ("Swift Quiver", (byte)5, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.RANGER}),
    SYMBOL ("Symbol", (byte)7, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.WIZARD}),
    TASHASHIDEOUSLAUGHTER ("Tasha's Hideous Laughter", (byte)1, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.WIZARD}),
    TELEKINESIS ("Telekinesis", (byte)5, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    TELEPATHY ("Telepathy", (byte)8, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.WIZARD}),
    TELEPORT ("Teleport", (byte)7, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WIZARD}),
    TELEPORTATIONCIRCLE ("Teleportation Circle", (byte)5, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WIZARD}),
    TENSERSFLOATINGDISK ("Tenser's Floating Disk", (byte)1, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.WIZARD}),
    THAUMATURGY ("Thaumaturgy", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.CLERIC}),
    THORNWHIP ("Thorn Whip", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID}),
    THUNDEROUSSMITE ("Thunderous Smite", (byte)1, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.PALADIN}),
    THUNDERWAVE ("Thunderwave", (byte)1, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.BARD, dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    TIMESTOP ("Time Stop", (byte)9, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    TONGUES ("Tongues", (byte)3, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    TRANSPORTVIAPLANTS ("Transport Via Plants", (byte)6, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID}),
    TREESTRIDE ("Tree Stride", (byte)5, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER}),
    TRUEPOLYMORPH ("True Polymorph", (byte)9, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.BARD, dndClasses.WARLOCK, dndClasses.WIZARD}),
    TRUERESURRECTION ("True Resurrection", (byte)9, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.CLERIC, dndClasses.DRUID}),
    TRUESEEING ("True Seeing", (byte)6, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    TRUESTRIKE ("True Strike", (byte)0, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    TSUNAMI ("Tsunami", (byte)8, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID}),
    UNSEENSERVANT ("Unseen Servant", (byte)1, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.BARD, dndClasses.WARLOCK, dndClasses.WIZARD}),
    VAMPIRICTOUCH ("Vampiric Touch", (byte)3, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.WARLOCK, dndClasses.WIZARD}),
    VICIOUSMOCKERY ("Vicious Mockery", (byte)0, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD}),
    WALLOFFIRE ("Wall Of Fire", (byte)4, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    WALLOFFORCE ("Wall Of Force", (byte)5, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.WIZARD}),
    WALLOFICE ("Wall Of Ice", (byte)6, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.WIZARD}),
    WALLOFSTONE ("Wall Of Stone", (byte)5, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    WALLOFTHORNS ("Wall Of Thorns", (byte)6, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID}),
    WARDINGBOND ("Warding Bond", (byte)2, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.CLERIC}),
    WATERBREATHING ("Water Breathing", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER, dndClasses.SORCERER, dndClasses.WIZARD}),
    WATERWALK ("Water Walk", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.DRUID, dndClasses.RANGER, dndClasses.SORCERER}),
    WEB ("Web", (byte)2, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    WEIRD ("Weird", (byte)9, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.WIZARD}),
    WINDWALK ("Wind Walk", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID}),
    WINDWALL ("Wind Wall", (byte)3, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER}),
    WISH ("Wish", (byte)9, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    WITCHBOLT ("Witch Bolt", (byte)1, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    WORDOFRECALL ("Word Of Recall", (byte)6, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.CLERIC}),
    WRATHFULSMITE ("Wrathful Smite", (byte)1, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.PALADIN}),
    ZONEOFTRUTH ("Zone Of Truth", (byte)2, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.CLERIC, dndClasses.PALADIN}),

    //Xanathar's Guide to Everything spells
    ABIDALZIMSHORRIDWILTING ("Abi-Dalzim's Horrid Wilting", (byte)8, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    ABSORBELEMENTS ("Absorb Elements", (byte)1, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER, dndClasses.WIZARD, dndClasses.SORCERER}),
    AGANAZZARSSCORCHER ("Aganazzar's Scorcher", (byte)2, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    BEASTBOND ("Beast Bond", (byte)1, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER}),
    BONESOFTHEEARTH ("Bones of the Earth", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID}),
    CATAPULT ("Catapult", (byte)1, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    CATNAP ("Catnap", (byte)3, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.WIZARD, dndClasses.BARD, dndClasses.SORCERER}),
    CAUSEFEAR ("Cause Fear", (byte)1, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.WARLOCK, dndClasses.WIZARD}),
    CEREMONY ("Ceremony", (byte)1, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.PALADIN}),
    CHAOSBOLT ("Chaos Bolt", (byte)1, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER}),
    CHARMMONSTER ("Charm Monster", (byte)4, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    CONTROLFLAMES ("Control Flames", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    CONTROLWINDS ("Control Winds", (byte)5, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    CREATEBONFIRE ("Create Bonfire", (byte)0, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    CREATEHOMUNCULUS ("Create Homunculus", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.WIZARD}),
    CROWNOFSTARS ("Crown of Stars", (byte)7, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    DANSEMACABRE ("Danse Macabre", (byte)5, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.WARLOCK, dndClasses.WIZARD}),
    DAWN ("Dawn", (byte)5, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.WIZARD}),
    DRAGONSBREATH ("Dragon's Breath", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    DRUIDGROVE ("Druid Grove", (byte)6, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.DRUID}),
    DUSTDEVIL ("Dust Devil", (byte)2, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    EARTHBIND ("Earthbind", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.BARD, dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    EARTHTREMOR ("Earth Tremor", (byte)1, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    ELEMENTALBANE ("Elemental Bane", (byte)4, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID, dndClasses.WIZARD, dndClasses.WARLOCK}),
    ENEMIESABOUND ("Enemies Abound", (byte)3, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    ENERVATION ("Enervation", (byte)5, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    ERUPTINGEARTH ("Erupting Earth", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    FARSTEP ("Far Step", (byte)5, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    FINDGREATERSTEED ("Find Greater Steed", (byte)4, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.PALADIN}),
    FLAMEARROWS ("Flame Arrows", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER, dndClasses.SORCERER, dndClasses.WIZARD}),
    FROSTBITE ("Frostbite", (byte)0, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    GUARDIANOFNATURE ("Guardian of Nature", (byte)4, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER}),
    GUST ("Gust", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    HEALINGSPIRIT ("Healing Spirit", (byte)2, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER}),
    HOLYWEAPON ("Holy Weapon", (byte)5, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.PALADIN}),
    ICEKNIFE ("Ice Knife", (byte)1, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    ILLUSORYDRAGON ("Illusory Dragon", (byte)8, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.WIZARD}),
    IMMOLATION ("Immolation", (byte)5, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    INFERNALCALLING ("Infernal Calling", (byte)5, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.WARLOCK, dndClasses.WIZARD}),
    INFESTATION ("Infestation", (byte)0, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    INVESTITUREOFFLAME ("Investiture of Flame", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    INVESTITUREOFICE ("Investiture of Ice", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    INVESTITUREOFSTONE ("Investiture of Stone", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    INVESTITUREOFWIND ("Investiture of Wind", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    INVULNERABILITY ("Invulnerability", (byte)9, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.WIZARD}),
    LIFETRANSFERENCE ("Life Transference", (byte)3, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.CLERIC, dndClasses.WIZARD}),
    MADDENINGDARKNESS ("Maddening Darkness", (byte)8, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.WARLOCK, dndClasses.WIZARD}),
    MAELSTROM ("Maelstrom", (byte)5, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.DRUID}),
    MAGICSTONE ("Magic Stone", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID, dndClasses.WARLOCK}),
    MASSPOLYMORPH ("Mass Polymorph", (byte)9, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD, dndClasses.BARD}),
    MAXIMILIANSEARTHENGRASP ("Maximilian's Earthen Grasp", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    MELFSMINUTEMETEORS ("Melf's Minute Meteors", (byte)3, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    MENTALPRISON ("Mental Prison", (byte)6, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    MIGHTYFORTRESS ("Mighty Fortress", (byte)8, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.WIZARD}),
    MINDSPIKE ("Mind Spike", (byte)2, dndSpellSchool.DIVINATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    MOLDEARTH ("Mold Earth", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    NEGATIVEENERGYFLOOD ("Negative Energy Flood", (byte)5, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.WARLOCK, dndClasses.WIZARD}),
    POWERWORDPAIN ("Power Word Pain", (byte)7, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    PRIMALSAVAGERY ("Primal Savagery", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID}),
    PRIMORDIALWARD ("Primordial Ward", (byte)6, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.DRUID}),
    PSYCHICSCREAM ("Psychic Scream", (byte)9, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    PYROTECHNICS ("Pyrotechnics", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WIZARD}),
    SCATTER ("Scatter", (byte)6, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    SHADOWBLADE ("Shadow Blade", (byte)2, dndSpellSchool.ILLUSION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    SHADOWOFMOIL ("Shadow of Moil", (byte)4, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.WARLOCK}),
    SHAPEWATER ("Shape Water", (byte)0, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    SICKENINGRADIANCE ("Sickening Radiance", (byte)4, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    SKILLEMPOWERMENT ("Skill Empowerment", (byte)5, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WIZARD}),
    SKYWRITE ("Skywrite", (byte)2, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.BARD, dndClasses.DRUID, dndClasses.WIZARD}),
    SNARE ("Snare", (byte)1, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER, dndClasses.WIZARD}),
    SNILLOCSSNOWBALLSWARM ("Snilloc's Snowball Swarm", (byte)2, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    SOULCAGE ("Soul Cage", (byte)6, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.WARLOCK, dndClasses.WIZARD}),
    STEELWINDSTRIKE ("Steel Wind Strike", (byte)5, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.RANGER, dndClasses.WIZARD}),
    STORMSPHERE ("Storm Sphere", (byte)4, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    SUMMONGREATERDEMON ("Summon Greater Demon", (byte)4, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.WARLOCK, dndClasses.WIZARD}),
    SUMMONLESSERDEMONS ("Summon Lesser Demons", (byte)3, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.WARLOCK, dndClasses.WIZARD}),
    SYNAPTICSTATIC ("Synaptic Static", (byte)5, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    TEMPLEOFTHEGODS ("Temple of the Gods", (byte)7, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.CLERIC}),
    TENSERSTRANSFORMATION ("Tenser's Transformation", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.WIZARD}),
    THUNDERCLAP ("Thunderclap", (byte)0, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.DRUID, dndClasses.WARLOCK, dndClasses.WIZARD}),
    THUNDERSTEP ("Thunder Step", (byte)3, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    TIDALWAVE ("Tidal Wave", (byte)3, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.WIZARD, dndClasses.SORCERER}),
    TINYSERVANT ("Tiny Servant", (byte)3, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.WIZARD}),
    TOLLTHEDEAD ("Toll the Dead", (byte)0, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.WARLOCK, dndClasses.WIZARD, dndClasses.CLERIC}),
    TRANSMUTEROCK ("Transmute Rock", (byte)5, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.DRUID, dndClasses.WIZARD}),
    VITRIOLICSPHERE ("Vitriolic Sphere", (byte)4, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    WALLOFLIGHT ("Wall of Light", (byte)5, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    WALLOFSAND ("Wall of Sand", (byte)3, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.WIZARD}),
    WALLOFWATER ("Wall of Water", (byte)3, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    WARDINGWIND ("Warding Wind", (byte)2, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.BARD, dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    WATERYSPHERE ("Watery Sphere", (byte)4, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.SORCERER, dndClasses.WIZARD}),
    WHIRLWIND ("Whirlwind", (byte)7, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.DRUID, dndClasses.WIZARD, dndClasses.SORCERER}),
    WORDOFRADIANCE ("Word of Radiance", (byte)0, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.CLERIC}),
    WRATHOFNATURE ("Wrath of Nature", (byte)5, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER}),
    ZEPHYRSTRIKE ("Zephyr Strike", (byte)1, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.RANGER}),

    //Tasha's
    BLADEOFDISASTER ("Blade of Disaster", (byte)9, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    BOOMINGBLADE ("Booming Blade", (byte)0, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.ARTIFICER, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    DREAMOFTHEBLUEVEIL ("Dream of the Blue Veil", (byte)7, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    GREENFLAMEBLADE ("Green-Flame Blade", (byte)0, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.ARTIFICER, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    INTELLECTFORTRESS ("Intellect Fortress", (byte)3, dndSpellSchool.ABJURATION, new dndClasses[]{dndClasses.ARTIFICER, dndClasses.BARD, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    LIGHTNINGLURE ("Lightning Lure", (byte)0, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.ARTIFICER, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    MINDSLIVER ("Mind Sliver", (byte)0, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    SPIRITSHROUD ("Spirit Shroud", (byte)3, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.CLERIC, dndClasses.PALADIN, dndClasses.WARLOCK, dndClasses.WIZARD}),
    SUMMONABERRATION ("Summon Aberration", (byte)4, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.WARLOCK, dndClasses.WIZARD}),
    SUMMONBEAST ("Summon Beast", (byte)2, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER}),
    SUMMONCELESTIAL ("Summon Celestial", (byte)5, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.CLERIC, dndClasses.PALADIN}),
    SUMMONCONSTRUCT ("Summon Construct", (byte)4, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.ARTIFICER, dndClasses.WIZARD}),
    SUMMONELEMENTAL ("Summon Elemental", (byte)4, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER, dndClasses.WIZARD}),
    SUMMONFEY ("Summon Fey", (byte)3, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.DRUID, dndClasses.RANGER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    SUMMONFIEND ("Summon Fiend", (byte)6, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.WARLOCK, dndClasses.WIZARD}),
    SUMMONSHADOWSPAWN ("Summon Shadowspawn", (byte)3, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.WARLOCK, dndClasses.WIZARD}),
    SUMMONUNDEAD ("Summon Undead", (byte)3, dndSpellSchool.NECROMANCY, new dndClasses[]{dndClasses.WARLOCK, dndClasses.WIZARD}),
    SWORDBURST ("Sword Burst", (byte)0, dndSpellSchool.CONJURATION, new dndClasses[]{dndClasses.ARTIFICER, dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD}),
    TASHASCAUSTICBREW ("Tasha's Caustic Brew", (byte)1, dndSpellSchool.EVOCATION, new dndClasses[]{dndClasses.ARTIFICER, dndClasses.SORCERER, dndClasses.WIZARD}),
    TASHASMINDWHIP ("Tasha's Mind Whip", (byte)2, dndSpellSchool.ENCHANTMENT, new dndClasses[]{dndClasses.SORCERER, dndClasses.WIZARD}),
    TASHASOTHERWORLDLYGUISE ("Tasha's Otherworldly Guise", (byte)6, dndSpellSchool.TRANSMUTATION, new dndClasses[]{dndClasses.SORCERER, dndClasses.WARLOCK, dndClasses.WIZARD});

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
    private final HashSet<dndClasses> classes = new HashSet<>();
    /**
     * A static member field storing how many spells there are
     */
    private static final int size = dndSpells.values().length;
    /**
     * A static member field storing a list of all spells values. Uppercase, letters only.
     */
    private static final HashSet<String> validFormattedNames = new HashSet<String>();     //A HashSet of the valid spell names. Uppercase only.
    static{
        for(dndSpells name : EnumSet.allOf(dndSpells.class))
            validFormattedNames.add(name.name());
    }

    /**
     * Constructor for the dndSpells enum
     * @param spellName The fully punctuated and formatted name of the spell
     * @param level The level of the spell
     * @param school The school the spell belongs to
     * @param classes An array of all classes this spell can be used by
     */
    dndSpells(final String spellName, final byte level, final dndSpellSchool school, final dndClasses[] classes) {
        this.spellName = spellName;
        this.level = level;
        this.school = school;
        for(dndClasses cl : classes)    //Transferring the array of classes passed in the constructor into a HashSet for quicker lookup time.
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
    static class spellSorter implements Comparator<dndSpells>
    {
        /**
         * Overriden compare method that uses String.compareTo(String)
         * @param a The first spell to compare with
         * @param b The spell to compare against
         * @return The value returned by String.compareTo(String)
         */
        @Override
        public int compare(dndSpells a, dndSpells b)
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
     * Returns a set of dndClasses that can use this spell
     * @return A Set containing all dndClasses that can use this spell
     */
    protected Set<dndClasses> getSpellClasses() {
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
