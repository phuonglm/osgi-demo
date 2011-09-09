OSGi Demo Project
-----------------

How to compile the bundle
-----------------
<pre>
git clone git@github.com:ly-minh-phuong-1403/osgi-demo.git
cd osgi-demo
mvn clean install
</pre>
after install all demo's bundles locate at {M2_REPOSITORY}/org/exoplatform/study/osgi/component-system/

How to run the demo using pax runner
----------------
<pre>
mvn clean install pax:provision
</pre>

more infomation about paxrunner maven plugin locate here.
http://www.ops4j.org/projects/pax/construct/maven-pax-plugin/plugin-info.html