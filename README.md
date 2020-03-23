# TruHApp
TrueCaller Url Hit App. To implement the app I have used Mobius Architecture using Test Driven Development written in Kotlin. Following is a deep dive into the implementation. <br>
### External Libraries Used:
 1. <a href="https://square.github.io/retrofit/">Retrofit</a>
 2. <a href="https://inthecheesefactory.com/blog/say-goodbye-to-findviewbyid-with-data-binding-library/en">Data Binding Library</a>

### Architecture Used: 
1. <a href="https://github.com/spotify/mobius">Mobius</a>

### Language Used: 
1. <a href="https://kotlinlang.org/">Kotlin</a>

### State Chart Diagram:
<img src="https://github.com/janhavisinghh/janhavi_singh/blob/master/state_chart_diagram.png" width="850" align="middle"><br>
#### State chart diagram is for the multiple states the app is going to be in. 
In the diagram, 
 1. The nodes represent different Models
 2. Arrows represent Events
 3. Dotted arrows adjoining the little circle represents an Effect
 4. Nodes with dotted borderline represent a No Change Model

### Implementation Guide: 
- Mobius is an Architecture introduced by Spotify which follows the <a href="https://raw.githubusercontent.com/wiki/spotify/mobius/mobius-diagram.png">Mobius Loop</a>. 
- Start from the `TrueCallerUpdateTest` class. Update function is the heart of Mobius Loop. All the events pass through the update function and then dispatch the next model or an effect. 
- Effects are impure functions. Things like making a network call or showing a toast message are done in the `TrueCallerEffectHandler` class.
- `TrueCallerViewRenderer` class implements the 3 algorithms for displaying needed output. 
- Unit Tests are written for the above classes in `TrueCallerViewRendererTest`, `TrueCallerEffectHandlerTest`, and `TrueCallerUpdateTest`

### Project Screenshots:
<p float="left">
<img src="https://github.com/janhavisinghh/janhavi_singh/blob/master/TruHApp_screen_shot_1.jpg" width="250">
<img src="https://github.com/janhavisinghh/janhavi_singh/blob/master/TruHApp_screen_shot_2.jpg" width="250">
</p>
