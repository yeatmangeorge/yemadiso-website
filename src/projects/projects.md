---
layout: base.njk
title: Yemadiso - Projects
description: Take a look at our current and previous work.
---
<header class="hero">

# Projects
Looking for some inspiration? Take a look at some of our current and past projects.

</header>

<header class="hero">

## MacroLens


Get the most out of your protein and meal replacement powders. Calculate macros, make better decisions.

<img src="/assets/images/macrolens_screenshot.webp" alt="MacroLens main calculator screen." class="phone-screenshot"/>

<article class="card">

### Precisely optimise your macro intake
You know your macro goals. MacroLens works out exactly how much protein powder or meal replacement you need to hit them.

Save time and be more precise calculating.
</article>

<article class="card">

### All your favourite powders

Browse an extensive database of protein powders and meal replacements. Then immediately start calculating.
</article>

<article class="card">

### Track your shakes, gain insights
Track your shakes over time and gain insights into your protein powder and meal replacement usage.

<span class="badge">Feature Coming Soon</span>
</article>

### Legal
<div class="card-container">
    <a href="macrolens/privacy-policy/" class="card">
        <h3>Privacy Policy</h3>
    </a>
    <a href="macrolens/cookie-policy/" class="card">
        <h3>Cookie Policy</h3>
    </a>
    <a href="macrolens/terms-of-use/" class="card">
        <h3>Terms of Use</h3>
    </a>
</div>

## Call the Scribe


Provided tech support for an interactive artwork using face-detection and a real time server.

<div class="image-container">
    <img class="content-image" src="/assets/images/call_the_scribe_demo.webp" alt="Image showing two participants performing Call the Scribe">
</div>
<article class="card">

### Real time subtitles

The work needed to display different subtitles to each computer in real time. The solution was to communicate with websockets and use a tick-based system, not too dissimilar from a game client and server.

The other challenge was determining how long to display each subtitle. Bergman needed to make fast and frequent changes to the scripts, so a linguistic analysis algorithm was implemented. This counted elements such as words, characters, punctuation, and the next subtitle to determine how long each subtitle should be displayed for.

</article>

<article class="card">

### Face-detection to automatically start the piece
The work required two people to be present in front of two different computers before it began. This presented an interesting challenge.

The solution was for each computer to detect if there was someone sat in front of itself and then report this to the server, which would manage the state based on messages received from each computer. 
</article>

<a href="https://liabergman.com/" class="card">

### Find out more
Click here to find out more about Call the Scribe and Bergman's other work.

</a>