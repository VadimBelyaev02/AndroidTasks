data class VenuesResponse(
    val results: List<Venue>,
    val context: Context
)

data class Venue(
    val fsq_id: String,
    val categories: List<Category>,
    val chains: List<Any>,
    val distance: Int,
    val geocodes: Geocodes,
    val link: String,
    val location: Location,
    val name: String,
    val related_places: RelatedPlaces,
    val timezone: String
)

data class Category(
    val id: Int,
    val name: String,
    val short_name: String,
    val plural_name: String,
    val icon: Icon
)

data class Icon(
    val prefix: String,
    val suffix: String
)

data class Geocodes(
    val main: Main
)

data class Main(
    val latitude: Double,
    val longitude: Double
)

data class Location(
    val address: String,
    val country: String,
    val cross_street: String,
    val formatted_address: String,
    val locality: String,
    val region: String
)

data class RelatedPlaces(
    val empty: Boolean
)

data class Context(
    val geo_bounds: GeoBounds
)

data class GeoBounds(
    val circle: Circle
)

data class Circle(
    val center: Main,
    val radius: Int
)
