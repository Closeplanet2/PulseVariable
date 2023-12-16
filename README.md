<h2 align="center">
<br>
<img src="Images/Logo.ong" alt="PulseVariable" width="600">
<br>
</h2>

**Downloads:**
- [All Downloads](https://github.com/Closeplanet2/PandaVariableCore)

**Tested Versions:**
- 1.20.1-R0.1-SNAPSHOT

**Other Plguins:**
- [PandaSpigotCore](https://github.com/Closeplanet2/PandaSpigotCore)
- [PandaVariableCore](https://github.com/Closeplanet2/PandaVariableCore)
- [PandaConfigCore](https://github.com/Closeplanet2/PandaConfigCore)
- [PandaCommandCore](https://github.com/Closeplanet2/PandaCommandCore)
- [PandaBossBarCore](https://github.com/Closeplanet2/PandaBossBarCore)
- [PandaSideBarCore](https://github.com/Closeplanet2/PandaSideBarCore)
- [PandaExternalCore](https://github.com/Closeplanet2/PandaExternalCore)
- [PandaMatchmakingCore](https://github.com/Closeplanet2/PandaMatchmakingCore)
- [PandaLeaderboardCore](https://github.com/Closeplanet2/PandaLeaderboardCore)

# Maven
```
<repository>
    <id>pulsevariable</id>
    <url>https://maven.pkg.github.com/closeplanet2/PulseVariable</url>
</repository>
```
```
<dependency>
  <groupId>com.pandapulsestudios</groupId>
  <artifactId>pulsevariable</artifactId>
  <version>1.0.1-a</version>
</dependency>
```

# Functions
* Check the type of object by passing in the class to check agaisnt and the data.
* Parse the object to a type by passing in the class and the data.
* Convert and De-convert the object for config use **(Used primary for Config Core)**
* Passing Array and Class Types
* Return custom tab data **(Used primary for Command Core)**

# Example Variable Logic Class

```
@VarTest
public class IntegerAPI implements VariableLogic {
    @Override
    public boolean IS_TYPE(String variable) {
        try {
            int x = Integer.parseInt(variable);
            return true;
        } catch (NumberFormatException e) { return false; }
    }

    @Override
    public List<Class<?>> CLASS_TYPE() {
        var data = new ArrayList<Class<?>>();
        data.add(int.class);
        data.add(Integer.class);
        return data;
    }

    @Override
    public List<Class<?>> ARRAY_TYPE() {
        var data = new ArrayList<Class<?>>();
        data.add(int[].class);
        data.add(Integer[].class);
        return data;
    }

    @Override
    public Object CONVERT_FOR_CONFIG(Object data) { return data.toString(); }

    @Override
    public Object DE_CONVERT_FOR_CONFIG(Object data) { return Integer.parseInt(data.toString()); }

    @Override
    public List<String> TAB_DATA(List<String> to_add, String currentArgument) { return new ArrayList<String>(); }
}
```

The above is a example of how each class is laid out. By Function:

* IS_TYPE: Allows you to add custom checks into the function to check if the **String** variable passed in is the type you expect and return the outcome. The above uses the inbuilt Integer.parseInt to check if the String passed in is a int.
* Class Type **(Is Used By Command Core & Config Core)**: Returns all the types that is class is repsonsible for. In this case both **int** objects are returned as both can be serialised with this class.
* Array Type **(Is Used By Command Core & Config Core)**: Returns all tyhe array types that this class is repsonsible for. In this case both **int** array objects are returned as both can be serialised with this class.
* CONVERT_FOR_CONFIG **(Is Used By Config Core)**: Allows you to add custom serialisation in to serialise the data passed in to the needed state to be saved to the config.
* DE_CONVERT_FOR_CONFIG **(Is Used By Config Core)**: Allows you to add custom de-serialisation in to de-serialise the data passed in to the needed state to be read from the config.
* TAB_DATA **(Is Used By Command Core)**: Allows you to return custom tab taba for when the command core recongises this as a option for tab data.

# Optional Functions

```
@VarTest
public class BanListType implements VariableLogic {

    ...

    default void CUSTOM_CAST_AND_PLACE(List<Object> toAdd, int place, List<?> castedData, Class<?> arrayType){ 
        toAdd.add(arrayType.cast(castedData.toArray())); 
    }

    default List<?> CONVERT(List<String> convert){
        var data = new ArrayList<>();
        for(var x : convert) data.add(CONVERT_FOR_CONFIG(x));
        return data;
    }

```

* CUSTOM_CAST_AND_PLACE **(Is Used By Command Core)**: Allows for the data to be cast from List<Object> to List<?> for command core to work. **This needs to filled in if command core is used.**
* CONVERT: Allows for mass convert if all the data is stored in the same list

# Stored Tests
All the follwing can be used by default and is auto seiralised in the Config Core and the Command Core.

* Art
* Axis
* BanList.Type
* BarColor
* BarStyle
* ChatColor
* CoalType
* CropState
* Difficulty
* DyeColor
* Effect
* Effect.Type
* EntityEffect
* FireworkEffect.Type
* Fluid
* FluidCollisionMode
* GameMode
* GrassSpecies
* HeightMap
* Instrument
* Material
* NetherWartsState
* Note.Tone
* Particle
* PortalType
* Raid.RaidStatus
* Rotation
* SandstoneType
* ~~SkullType~~
* Sound
* SoundCategory
* Statistic
* Statistic.Type
* ~~TreeSpecies~~
* TreeType
* Warning.WarningState
* WeatherType
* World.Environment
* WorldType
* Double / double
* Float / float
* Integer / int
* Long / long
* String
* Boolean
* UUID

# API

```
public static boolean REGISTER_VAR_TEST(Class<?> test_class, VariableLogic variableLogic, boolean override_if_found){
    ...
}

public static List<String> RETURN_AS_ALL_TYPES(String text, boolean uppercase, boolean lowercase, boolean isElementArray) {
    ...
}

public static VariableLogic RETURN_TEST_FROM_TYPE(String type, boolean searchByArrayType){
    ...
}
```

* REGISTER_VAR_TEST: Allows you to register a custom variable test
* RETURN_AS_ALL_TYPES: Returns past data as a list of all types it can pass to
* RETURN_TEST_FROM_TYPE: Return Variable test from the name given as type - Search by class type or array type

