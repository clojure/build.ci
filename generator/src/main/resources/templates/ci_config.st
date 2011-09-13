<?xml version='1.0' encoding='UTF-8'?>
<hudson>
  <version>1.386</version>
  <numExecutors>2</numExecutors>
  <mode>NORMAL</mode>
  <useSecurity>true</useSecurity>
  <authorizationStrategy class="hudson.security.ProjectMatrixAuthorizationStrategy">
    <permission>hudson.model.Hudson.Administer:abedra</permission>
    <permission>hudson.model.Hudson.Administer:cemerick</permission>
    <permission>hudson.model.Hudson.Administer:richhickey</permission>
    <permission>hudson.model.Hudson.Administer:stuart.halloway</permission>
    <permission>hudson.model.Hudson.Administer:stuartsierra</permission>
    <permission>hudson.model.Hudson.Read:anonymous</permission>
    <permission>hudson.model.Item.Read:anonymous</permission>
  </authorizationStrategy>
  <securityRealm class="hudson.security.HudsonPrivateSecurityRealm">
    <disableSignup>true</disableSignup>
  </securityRealm>
  <systemMessage>&lt;p&gt;Clojure build server; deploying to &lt;a href=&quot;https://oss.sonatype.org/&quot;&gt;oss.sonatype.org&lt;/a&gt;; releases are sync&apos;ed to the &lt;a href=&quot;http://repo1.maven.org/maven2&quot;&gt;Maven Central Repository&lt;/a&gt;.&lt;/p&gt;&#xd;
&lt;p&gt;Older &lt;a href=&quot;/releases&quot;&gt;releases&lt;/a&gt; and &lt;a href=&quot;/snapshots&quot;&gt;snapshots&lt;/a&gt; are hosted locally.&lt;/p&gt;&#xd;
&lt;p&gt;All projects build on Sun/Oracle JDK 1.5 unless specified otherwise.&lt;/p&gt;</systemMessage>
  <jdks>
    $jdks:{ jdk |<jdk>
  <name>$jdk.name$</name>
  <home>$jdk.home$</home>
  <properties/>
</jdk>}; separator="\n"$
  </jdks>
  <viewsTabBar class="hudson.views.DefaultViewsTabBar"/>
  <myViewsTabBar class="hudson.views.DefaultMyViewsTabBar"/>
  <clouds/>
  <slaves/>
  <quietPeriod>5</quietPeriod>
  <scmCheckoutRetryCount>0</scmCheckoutRetryCount>
  <views>
    <hudson.model.AllView>
      <owner class="hudson" reference="../../.."/>
      <name>All</name>
      <filterExecutors>false</filterExecutors>
      <filterQueue>false</filterQueue>
    </hudson.model.AllView>
    <listView>
      <owner class="hudson" reference="../../.."/>
      <name>Clojure</name>
      <filterExecutors>false</filterExecutors>
      <filterQueue>false</filterQueue>
      <jobNames class="tree-set">
        <comparator class="hudson.util.CaseInsensitiveComparator"/>
        <string>clojure</string>
        <string>clojure-test-matrix</string>
      </jobNames>
      <jobFilters/>
      <columns>
        <hudson.views.StatusColumn/>
        <hudson.views.WeatherColumn/>
        <hudson.views.JobColumn/>
        <hudson.views.LastSuccessColumn/>
        <hudson.views.LastFailureColumn/>
        <hudson.views.LastDurationColumn/>
        <hudson.views.BuildButtonColumn/>
      </columns>
    </listView>
    <listView>
      <owner class="hudson" reference="../../.."/>
      <name>Contrib Libraries</name>
      <filterExecutors>false</filterExecutors>
      <filterQueue>false</filterQueue>
      <jobNames class="tree-set">
        <comparator class="hudson.util.CaseInsensitiveComparator" reference="../../../listView/jobNames/comparator"/>
        $libs:{ name | <string>$name$</string>}; separator="\n"$
      </jobNames>
      <jobFilters/>
      <columns>
        <hudson.views.StatusColumn/>
        <hudson.views.WeatherColumn/>
        <hudson.views.JobColumn/>
        <hudson.views.LastSuccessColumn/>
        <hudson.views.LastFailureColumn/>
        <hudson.views.LastDurationColumn/>
        <hudson.views.BuildButtonColumn/>
      </columns>
    </listView>
    <listView>
      <owner class="hudson" reference="../../.."/>
      <name>Support</name>
      <filterExecutors>false</filterExecutors>
      <filterQueue>false</filterQueue>
      <jobNames class="tree-set">
        <comparator class="hudson.util.CaseInsensitiveComparator" reference="../../../listView/jobNames/comparator"/>
        <string>build.ci</string>
        <string>build.poms</string>
        <string>rebuild-all-libraries</string>
      </jobNames>
      <jobFilters/>
      <columns>
        <hudson.views.StatusColumn/>
        <hudson.views.WeatherColumn/>
        <hudson.views.JobColumn/>
        <hudson.views.LastSuccessColumn/>
        <hudson.views.LastFailureColumn/>
        <hudson.views.LastDurationColumn/>
        <hudson.views.BuildButtonColumn/>
      </columns>
    </listView>
  </views>
  <primaryView>All</primaryView>
  <slaveAgentPort>0</slaveAgentPort>
  <label></label>
  <crumbIssuer class="hudson.security.csrf.DefaultCrumbIssuer">
    <excludeClientIPFromCrumb>false</excludeClientIPFromCrumb>
    <PROXY__HEADER>X-Forwarded-For</PROXY__HEADER>
  </crumbIssuer>
  <nodeProperties/>
  <globalNodeProperties/>
  <disabledAdministrativeMonitors/>
</hudson>