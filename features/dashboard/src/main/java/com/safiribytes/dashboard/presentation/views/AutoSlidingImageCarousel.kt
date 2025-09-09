import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.*
import com.safiribytes.core.utils.Constants
import com.safiribytes.coreui.components.ShimmerEffect
import com.safiribytes.coreui.theme.chefapp.ChefAppTheme
import com.safiribytes.coreui.theme.userapp.UserAppTheme
import kotlinx.coroutines.delay
import kotlin.random.Random

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AutoSlidingCarousel(
    isLoading: Boolean,
    images: List<String>
) {
    // Check if images list is empty
    if (images.isEmpty()) {
        Text(text = "No data available", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
        return
    }

    val pagerState = rememberPagerState()
    val totalImages = images.size

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000) // Change image every 3 seconds
            pagerState.animateScrollToPage((pagerState.currentPage + 1) % totalImages)
        }
    }

    if (!isLoading) {
        AutoSlidingCarouselContent(
            images = images,
            pagerState = pagerState,
            totalImages = totalImages
        )
    }
    else {
        AutoSlidingCarouselShimmerEffect()
    }

}

@Composable
fun DotsIndicator(totalDots: Int, selectedIndex: Int, modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(totalDots) { index ->
            DotIndicator(isSelected = index == selectedIndex)

            if (index < totalDots - 1) {
                Spacer(modifier = Modifier.width(5.dp)) // Adjust the width as needed
            }
        }
    }
}

@Composable
fun DotIndicator(isSelected: Boolean) {
    val dotColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primary.copy(alpha = 0.33f)
    Box(
        modifier = Modifier
            .size(width = 35.dp, height = 8.dp)
    ){
        Canvas(
            modifier =  Modifier
                .size(width = 35.dp, height = 8.dp)
        ) {
            drawRoundRect(
                color = dotColor,
                size = size,
                cornerRadius = CornerRadius( 3.dp.toPx(),  3.dp.toPx())
            )
        }
    }
}


@Composable
fun AutoSlidingCarouselContent(
    images: List<String>,
    pagerState: PagerState,
    totalImages: Int,
    randomColor: Color = Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 0.2f)
) {

    Box(modifier = Modifier
        .height(200.dp)
        .background(randomColor, RoundedCornerShape(10.dp))
        .fillMaxWidth()
        .clip(RoundedCornerShape(15.dp))
    ) {
        HorizontalPager(
            count = totalImages,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))

        ) { page ->
            Image(
                painter = rememberImagePainter(data = "${Constants.BASE_URL}${images[page]}"),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        // Dots indicator at the bottom
        DotsIndicator(
            totalDots = totalImages,
            selectedIndex = pagerState.currentPage,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp)
        )
    }

}

@Composable
fun AutoSlidingCarouselShimmerEffect() {
    ShimmerEffect(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        cornerRadius = 10
    )
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun AutoSlidingCarouselContentPreview(){
    val images = listOf("img1", "img2")
    UserAppTheme {

        AutoSlidingCarouselContent(
            images = images,
            pagerState = rememberPagerState(),
            totalImages = images.size
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun AutoSlidingCarouselShimmerEffectPreview(){
    ChefAppTheme {
        AutoSlidingCarouselShimmerEffect()
    }
}

@Preview
@Composable
fun AutoSlidingCarouselPreview(){
    UserAppTheme {
        AutoSlidingCarousel(
            isLoading = false,
            images = listOf("img1", "img2")
        )
    }
}