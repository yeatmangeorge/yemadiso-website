module.exports = function (eleventyConfig) {
  eleventyConfig.addPassthroughCopy("src/css");
  eleventyConfig.addPassthroughCopy("src/js");
  eleventyConfig.addPassthroughCopy("src/CNAME");

  return {
    dir: {
      input: "src",
      includes: "_includes",
      output: "_site",
    },
    // Set this to "/your-repo-name" if this site is served from
    // https://username.github.io/repo-name/ rather than the account root.
    pathPrefix:
      process.env.ELEVENTY_ENV === "production"
        ? "/yemadiso-website/"
        : "/",
  };
};
